
def appVerion
def codeRevision

pipeline {
    agent 'any'
    stages {
        stage('Validate Commit') {
            steps {
                script {
                  appVersion = sh(returnStdout: true, script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout').trim()
                  codeRevision = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
                  echo "App version: $appVersion, Code revision: $codeRevision"
                    
                  build 'CD/1_commit_stage'
                }
            }
        }
        stage('Deploy To Prod-like Env') {
            steps {
                build job: 'CD/2_deploy_prod_like_environment', parameters: [
                    string(name: 'app_version', value: appVersion)
                ]
            }
        }
        stage('Run Acceptance Tests') {
            steps {
                build job: 'CD/3_acceptance_test_stage', parameters: [
                    string(name: 'app_version', value: appVersion),
                    string(name: 'code_revision', value: codeRevision)
                ]
            }
        }
    }
}
