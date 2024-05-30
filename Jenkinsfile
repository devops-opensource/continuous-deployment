node {
  // 1. Pipeline options: check for code change in GIT' and keep only two days of history.
  properties([pipelineTriggers([pollSCM('5 * * * *')]),[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', daysToKeepStr: '2', numToKeepStr: '5']]]);

  // 2. Clean workspace and checkout code from job SCM configurations
  stage("Checkout") {
    deleteDir()
    checkout scm
  }

  // 3. Let's build application within a Maven docker image
  stage("Build") {
      // Compile, Test and Package
      docker.image('maven').inside {
          sh "mvn package"
      }
  }

  // 4. Add Job Junit reporting inside Jenkins  
  stage("Report tests") {
      allure results: [[path: 'target/surefire-reports']]
      junit allowEmptyResults: true, testResults: '**/TEST-*.xml'
  }

  // 5. Deploy to AWS using Security credentials: ACCESS_KEY and SECRET from custom IAM Jenkins user
  docker.image('chriscamicas/awscli-awsebcli').inside {
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'AWS', usernameVariable: 'AWS_ACCESS_KEY_ID', passwordVariable: 'AWS_SECRET_ACCESS_KEY']]) {
      // Prepare environment by creating and prepare environments
      stage('Prepare environment') {
        sh 'eb init continuous-deployment-demo -p "corretto-17" --region "ca-central-1" '
        // Since AWS failed on create if environment already exists, try/catch block allow to continue deploy without failing
        try {
          sh 'eb create jenkins-env --single'
        } catch(e) {
          echo "Error while creating environment, continue..., cause: " + e
        }
        sh 'eb use jenkins-env'
        sh 'eb setenv SERVER_PORT=5000'
      }
      // Ready to deploy our new version !
      stage('Deploy') {
        sh 'eb deploy'
        sh 'eb status'
      }
    }
  }

}