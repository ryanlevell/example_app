
// do not allow concurrent builds

def appVerion
def codeRevision

pipeline {
    agent 'any'
    stages {
        stage('Commit Stage') {
            steps {
                script {
                  appVersion = sh(returnStdout: true, script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout').trim()
                  codeRevision = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
                  echo "App version: $appVersion, Code revision: $codeRevision"
                  currentBuild.displayName = "[$appVersion] ($codeRevision)"
                    
                  // TODO instantly fail if appVersion release version already exists in artifactory????
                  // TODO skip pipeline if codeRevision != latest revision (if multiple jobs piled up in queue, skip to the latest one)
                  // TODO output ATDD report  

                    echo 'Commit - compile'
                    echo 'Commit - security scans'
                    echo 'Commit - tests'
                    echo 'Commit - code analysis'
                    echo 'Commit - packaging'
                    echo 'Commit - prepare artifacts (test databases) for later stages'

                    echo 'Commit - deploy to prod-like environment (in this stage ?????)'

                    sh './mvnw -T1C clean install'
                    sh '/home/ubuntu/.fly/bin/flyctl deploy --config ./deploy/fly.staging.toml'
                }
            }
        }
        stage('Acceptance Test Stage') {
            agent {
                docker {
                    image 'mcr.microsoft.com/playwright/java:v1.30.0-focal'
                    reuseNode true
                }
            }
            steps {
                echo 'Acceptance Test - tests'
                echo 'Acceptance Test - deploy to other environments: key requirements are'
                echo '- to be able to see a list of release candidates that have passed the acceptance test stage'
                echo '- have a button to deploy the version of your choice into thr environment of your choice'
                echo '- see which release is currently deployed in each environment'
                echo '- and which version in version control it came from.'

                sh 'cd acceptance_test && ./mvnw clean test'
            }
        }
    }
}
