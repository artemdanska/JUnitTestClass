pipeline {
    agent any

    environment {
        IMAGE_NAME = "temperature-converter"
        DOCKER_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean package jacoco:report'
            }
            post {
                always {
                    jacoco(execPattern: '**/target/jacoco.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java')
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $IMAGE_NAME:$DOCKER_TAG ."
            }
        }

        stage('Run Docker Image') {
            steps {
                sh "docker run --rm -p 8080:8080 $IMAGE_NAME:$DOCKER_TAG"
            }
        }

        stage('Push to Docker Hub') {
            when {
                expression { return true }
            }
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    sh "docker tag $IMAGE_NAME:$DOCKER_TAG artemdanska/$IMAGE_NAME:$DOCKER_TAG"
                    sh "docker push artemdanska/$IMAGE_NAME:$DOCKER_TAG"
                }
            }
        }
    }
}