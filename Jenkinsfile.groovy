pipeline {
    agent 'any'
    stages {
        stage('Validate Commit') {
            steps {
                build 'CD/1_commit_stage'
            }
        }
        stage('Deploy To Prod-like Env') {
            steps {
                build 'CD/2_deploy_prod_like_environment'
            }
        }
        stage('Run Acceptance Tests') {
            steps {
                build 'CD/3_acceptance_test_stage'
            }
        }
    }
}
