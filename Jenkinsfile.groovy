
def appVerion
def codeRevision

pipeline {
    agent 'any'
    stages {
        stage('Validate Commit') {
            steps {
                script {
                  codeRevision = checkout(scm).GIT_COMMIT
                  echo "Code revision: $codeRevision"
                    
                  build 'CD/1_commit_stage'
                }
            }
        }
        stage('Deploy To Prod-like Env') {
            steps {
                build job: 'CD/2_deploy_prod_like_environment', parameters: [
                    string(name: 'app_version', value: '1.0.0')
                ]
            }
        }
        stage('Run Acceptance Tests') {
            steps {
                build job: 'CD/3_acceptance_test_stage', parameters: [
                    string(name: 'app_version', value: '1.0.0'),
                    string(name: 'code_revision', value: codeRevision)
                ]
            }
        }
    }
}
