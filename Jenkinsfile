pipeline {
    agent any

    triggers {
        pollSCM('*/1 * * * *')
    }

    stages {
        stage('Build') {
            steps {
                sh '''
                    javac --release 17 Main.java
                    java Main
                '''
            }
        }
    }
}
