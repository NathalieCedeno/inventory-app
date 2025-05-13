pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6' // Asegúrate de tener esta versión configurada en Jenkins
    }

    stages {
        stage('Build') {
            steps {
                echo 'Compilando el proyecto con Maven...'
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando pruebas con Maven...'
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Desplegando en entorno de prueba...'
                bat 'echo Despliegue simulado'
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminado.'
        }
        success {
            echo '¡Éxito!'
        }
        failure {
            echo 'Falló el pipeline.'
        }
    }
}
