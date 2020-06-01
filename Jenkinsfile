pipeline {
    agent {
        docker { image 'maven:3.6.3-openjdk-15' }
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