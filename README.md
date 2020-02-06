# Scrumconnect-java-poc

This API is used to store customer information to H2 db.<br/>

To run this app:

  - mvn build <br/>

  - java -jar target/scrumconnect-api-poc-0.0.1-SNAPSHOT.jar <br/>
  
To run tests:<br/>
- mvn test

It has only 1 endpoint  http://localhost:8080/api/v1/save<br/>

You need to post data with this method body<br/>

{
	"name":"Esen",
	"age":10,
 	"country":"United Kingom",
 	"sex":"Female"

}


