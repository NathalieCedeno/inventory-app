pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
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
            emailext subject: "✔️ Build exitoso: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "El build se ejecutó correctamente.\n\nVer detalles: ${env.BUILD_URL}",
                     to: 'nathalienicolecr19@gmail.com'
        }
        failure {
            echo 'Falló el pipeline.'
            emailext subject: "❌ Build fallido: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "El build falló.\n\nRevisión: ${env.GIT_COMMIT}\nDetalles: ${env.BUILD_URL}",
                     to: 'nathalienicolecr19@gmail.com'
        }
    }
}
