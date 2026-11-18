def call(String imageName) {
    stage('Docker Build & Push') {
        withCredentials([usernamePassword(credentialsId: 'DockerHub',
                                           usernameVariable: 'USER',
                                           passwordVariable: 'PASS')]) {
            sh '''
               echo "$PASS" | docker login -u "$USER" --password-stdin
               docker build -t ${imageName} .
               docker push ${imageName}
            '''
        }
    }
}
