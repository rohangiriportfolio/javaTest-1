pipeline {
    agent any

    triggers {
        pollSCM('*/1 * * * *')
        cron('*/3 * * * *')
    }

    stages {
        stage('Build') {
            steps {
                sh '''
                    javac --release 17 Test.java
                    java Test
                '''
            }
        }
        stage('Trigger Upstream') {
            steps {
                build job: 'before-declare', wait: true
            }
        }
    }
}
