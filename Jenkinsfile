pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh '''
                cd myApp/src/test/java/cucumber_options
                javac TestNGRunner.java
                java TestNGRunner
                '''
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
                sh '''
                '''
            }
        }
        stage('Deliver') {
            steps {
                echo 'Deliver....'
                sh '''
                '''
            }
        }
    }
}
