pipeline {
    agent any

    environment {
            M2_HOME = '/usr/share/maven/bin'
            MAVEN_HOME = '/usr/share/maven/bin'
    }

    stages {

        stage('init') {
            steps {
                echo "PATH = ${PATH}"
            }
        }
        stage('Build') {
            steps {
                   withMaven {
                    sh ' mvn -f pom.xml clean install'
                   }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
