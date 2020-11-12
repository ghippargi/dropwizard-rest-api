# dropwizard-rest-api
REST API implemented with latest Dropwizard framework

Uses Maven. 
Pre-requisits:
1. Install Java8
2. Install Maven

Steps to build and run the project:
1. Checkout the code.
2. From withing the checked-out directory, execute 'mvn clean install -Dmaven.test.skip=true' to build the project.
3. Execute the following command 'java -jar target/movie-api-dropwizard-1.0-SNAPSHOT.jar server config.yml'

On successful execution, the REST APIs are available on port 8095.
