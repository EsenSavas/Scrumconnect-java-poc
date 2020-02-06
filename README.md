# Scrumconnect-java-poc

This API is used to store customer information to H2 db.<br/>

### Run

  - mvn build <br/>

  - java -jar target/scrumconnect-api-poc-0.0.1-SNAPSHOT.jar <br/>
  
It has only 1 endpoint  http://localhost:8080/api/v1/save<br/>

You need to post data with this method body<br/>

{
	"name":"Esen",
	"age":10,
 	"country":"United Kingom",
 	"sex":"Female"

}


### Test
- mvn test

### Swagger File

Call http://localhost:8080/v2/api-docs to view endpoints

<img width="789" alt="Screen Shot 2020-02-06 at 22 46 21" src="https://user-images.githubusercontent.com/33178686/73985254-9ed25b80-4932-11ea-8b22-27bd0124e2b7.png"> 

<img width="808" alt="Screen Shot 2020-02-06 at 22 42 04" src="https://user-images.githubusercontent.com/33178686/73985030-0b992600-4932-11ea-9236-5854e99c9da5.png">

<img width="951" alt="Screen Shot 2020-02-06 at 22 18 00" src="https://user-images.githubusercontent.com/33178686/73983666-d3441880-492e-11ea-9809-9855b480250f.png">



