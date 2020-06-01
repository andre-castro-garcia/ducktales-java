pipeline {
    agent {
        docker { image '3.6.3-ibmjava-8-alpine' }
    }
    stages {
        stage('Build application') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run tests and publish coverage') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}