Pipeline DockerPipeLine

node ('build-agent') {
   stage('Fetch Code') {
       git 'https://github.com/jaiminge/demoDevops.git'
   }
   stage('Building') {
       mvnHome = tool 'mvn'
       sh 'mvn clean package'
   }
   stage('Archiving') {
       echo 'Now Archiving...'
       archiveArtifacts artifacts: '**/target/*.war'
   }
   stage('Transfer War') {
       sh 'scp -i /Users/jaimegutierrez/Desktop/bashTestFiles/weblogicKey.pem /home/ec2-user/demoDevops/hexaware-master/target/*.war ubuntu@ec2-18-217-28-103.us-east-2.compute.amazonaws.com:/home/ubuntu'
   }
}

node('docker-agent') {
   stage('Deploy on Prod') {
        timeout(time:1, unit:'DAYS'){
            input message: 'Approve Production Deployment?'
        }
       build job: 'Docker-Deploy-Prod'
   }
}