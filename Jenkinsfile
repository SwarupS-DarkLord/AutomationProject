pipeline {
    agent any

    environment {
        // Set the GitHub repository URL
        GIT_URL = 'https://github.com/SwarupS-DarkLord/AutomationProject.git'
    }

    // Define the stages
    stages {
        stage('Checkout') {
            steps {
                // Checkout the latest code from GitHub
                git url: GIT_URL, branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        bat 'mvn clean install -DskipTests=false'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                // Publish TestNG results
                junit '**/target/test-*.xml'
            }
        }
    }

    // Define triggers
    triggers {
        // Trigger a build on every commit to the master branch
        githubPush()

        // Trigger a build once per day
        cron('H 0 * * *')  // This runs at midnight every day
    }

    post {
        success {
            // Log success message when the build is successful
            echo 'Build and Tests completed successfully!'
        }
        failure {
            // Log failure message when the build or tests fail
            echo 'Build or Tests failed, but pipeline continued to completion.'
        }
    }
}
