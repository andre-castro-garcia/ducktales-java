pipeline {
    agent {
        docker { image 'maven:8-alpine' }
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