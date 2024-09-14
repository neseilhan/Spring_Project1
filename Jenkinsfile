pipeline {
    agent any

    environment {
        // Define the location of your database or other environment variables if needed
        DATABASE_URL = 'jdbc:postgresql://localhost:5432/hibernate2'
        DATABASE_USERNAME = 'postgres'
        DATABASE_PASSWORD = 'postgres'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Checkout code from your source control (GitHub, GitLab, etc.)
                git branch: 'master', url: 'https://github.com/neseilhan/Spring_Project1.git'
            }
        }

        stage('Build') {
            steps {
                // Clean and compile the Maven project
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the application into a JAR file
                sh 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                // Build Docker image for the Spring Boot application
                sh 'docker build -t spring_project1:latest .'
            }
        }

       stage('Docker Push') {
           steps {
               // Push Docker image to Docker registry
               withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                   sh 'docker login -u neseilhan -p nesenese1234'
                   sh 'docker tag spring_project1:latest neseilhan/spring_project1:latest'
                   sh 'docker push neseilhan/spring_project1:latest'
               }
           }
       }

        stage('Deploy') {
            steps {
                // Deploy Docker image to the server or environment
                sh 'docker-compose down && docker-compose up -d'
            }
        }
    }

    post {
            success {
                echo 'Build and Deploy succeeded!'
            }
            failure {
                echo 'Build or Deploy failed!'
            }

        always {
            // Clean workspace after build
            cleanWs()
        }
    }
}
