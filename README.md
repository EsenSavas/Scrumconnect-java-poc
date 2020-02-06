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

<img width="951" alt="Screen Shot 2020-02-06 at 22 18 00" src="https://user-images.githubusercontent.com/33178686/73983666-d3441880-492e-11ea-9809-9855b480250f.png">

