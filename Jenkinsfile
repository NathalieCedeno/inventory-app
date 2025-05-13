pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
                bat 'npm install'
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando pruebas...'
                bat 'npm test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Desplegando en entorno de prueba...'
                bat 'echo "Despliegue simulado"'
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
