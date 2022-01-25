pipeline {
    agent any

    environment {
            M2_HOME = '/usr/share/maven/bin'
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
                    sh ' mvn -f pom.xml clean compile'
                   }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                withMaven {
                    sh ' mvn -f pom.xml clean test'
                   }
            }
        }
    }
}
