Docker-Deploy-Prod

node('docker-agent') {
   stage('Stop All Containers') {
       sh 'sudo docker stop $(sudo docker ps -a -q)'
   }
   
   stage('Remove Old Containers') {
       sh 'sudo docker rm $(sudo docker ps -a -q)'
   }
   
 /*  stage('Revemo Old Images') {
       sh "sudo docker rmi $(sudo docker images|grep ubuntu/war-artifact|sed 's/\s\+/ /g'|cut -d' ' -f3)"
   }*/
   
   stage('Building New Volume') {
       sh 'sudo docker build -t ubuntu/war-artifact:1.0 . -f Dockerfile'
       sh 'rm demo-1.0.war'
   }
   stage('Start Deploy') {
        sh 'sudo docker-compose up -d'
   }
}