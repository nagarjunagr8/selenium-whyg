pipeline {
    agent any
    tools {
        maven "Default"
        jdk 'Default'
    }
    stages {
        stage('selenium test') {
            steps {
                git 'https://github.com/nagarjunagr8/selenium-whyg.git'
                bat "mvn clean test"
                junit 'target/surefire-reports/*.xml'
            }
            agent {
                label 'selenium-agent'
            }
            tools {
                maven "selenium-agent_mvn"
                jdk "selenium-agent_jdk"
                git "selenium-agent_git"
            }
        }
    }
}