**Prompt:**  

I am a DevOps specialist and I want to generate a complete CI/CD pipeline for my Java application.  

# **Pipeline Requirements:**  
The pipeline should be fully automated and follow best practices for security, reliability, and performance.  

It should include the following stages:  

## **1. Checkout:**  
- Clean the workspace and fetch the latest code from SCM.  

## **2. Build:**  
- Set up Java.   
- Compile the Java application using Maven.  
- Ensure dependencies are resolved.  
- Create an executable JAR package.  

## **3. Tests:**  
- Run unit tests and integration tests.  
- Generate test reports and upload artifacts for analysis.  

## **4. Publish:**  
- Build a Docker image for the application.  
- Tag and push the Docker image to registry. 

## **5. Deploy:**  
- Initialize the environment
- Create a deployment package.  
- Deploy the Docker container.   
- Ensure the application runs.  
- Perform health checks to verify the deployment.  

## **Pipeline Triggers:**  
- Trigger on push to the main branch.  
- Run build and tests on all merge requests targeting the main branch.  
- Support manual deployment via pipeline execution.  

## **Security & Configurations:**  
- All credentials (Access Key, Secret Key) should be stored securely in CI/CD Variables.  
- Use the least privileged IAM roles to ensure security.  
- Ensure best practices for Docker security (e.g., minimal base image, non-root user).  
- Leverage tool caching for Maven dependencies to optimize build times.  

## **Technical Details:**  
- **Application Name:** Continuous Deployment Application Demo  
- **Description:** A Java application demonstrating an end-to-end CI/CD pipeline.  
- **Programming Language:** Java  
- **Java Version:** 17 (Amazon Corretto 17)  
- **Build Tool:** Maven  
- **Docker Image Name:** `continuous-deployment-application-demo`  
- **Docker registry:** `AWS Elastic Container Registry (ECR)` 
- **CI/CD Platform:** `GitLab CI/CD`
- **Deployment Platform:** AWS Elastic Beanstalk  
- **Deployment Region:** `ca-central-1`  
- **Deployment Environment Name:** `continuous-deployment-application-demo`  
- **Port:** `5000`  

## **Expected Output:**  
- A declarative pipeline file that adheres to the above requirements.  
- Clearly defined stages and steps within the pipeline.  
- Secure handling of AWS credentials and Docker authentication.  
- A reliable deployment strategy with proper health checks.  
- A human-readable comment for each stage to improve maintainability.  