# Spring-Boot Project for Continuous Deployment demonstration

This project is a simple example of Rest API to demonstrate the steps and principles of continuous delivery across different platforms.

Java Spring-Boot Built from [Spring Boot Initializer](https://start.spring.io/), it compiles with Maven, it contains a Tomcat Server Embedded and deploy easily on AWS BeanStalk Platform.

## Requirement

* AWS Account (needs AccesKey and SecretID)
* Docker machine
* A remote git repository
* Fork this repository

## Pipeline steps

### Test

`mvn test`

### Build

`mvn package`

### Deploy to AWS

Configure config.xml in .elastikbeanstalk folder
Export ACCESS_ID and SECRET_KEY as environment variables

* Initialize eb-cli:

`eb init continuous-deployment-demo -p "64bit Amazon Linux 2017.09 v2.6.4 running Java 8" --region "ca-central-1"`

* Create (optional) environment:

`eb create jenkins-env --single`

* Use environment:

`eb use xyz-env`

* Set Spring-boot SERVER_PORT environment variable:

`eb setenv SERVER_PORT=5000`

* Finally Deploy: 

`eb deploy`
