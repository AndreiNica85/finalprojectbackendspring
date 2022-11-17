package com.finalproject.spring;


import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	private static final RequestSpecification requestSpecificationBaseURI = new RequestSpecBuilder()
			.setContentType(ContentType.JSON)
			.setBaseUri("http://localhost:8080/users")
			.build();

	@Test
	void contextLoads() {
		// Post User 1
		RequestSpecification requestSpecification1 = given().spec(requestSpecificationBaseURI).body(
				"{\"id\":\"1\",\"firstName\":\"Nica\",\"lastName\":\"Andrei\",\"phoneNumber\":\"45435\",\"email\":\"andrein@solera\"}").when();
		ResponseSpecification responseSpecification1 = new ResponseSpecBuilder().expectStatusCode(200).build();
		Response response1 = requestSpecification1.when().post("http://localhost:8080/users")
				.then().spec(responseSpecification1).extract().response();
		System.out.println(response1);

		// Post User 2
		RequestSpecification requestSpecification3 = given().spec(requestSpecificationBaseURI).body(
				"{\"id\":\"2\",\"firstName\":\"Vasile\",\"lastName\":\"Andrei\",\"phoneNumber\":\"451213435\",\"email\":\"petern@solera\"}").when();
		ResponseSpecification responseSpecification3 = new ResponseSpecBuilder().expectStatusCode(200).build();
		Response response3 = requestSpecification3.when().post("http://localhost:8080/users")
				.then().spec(responseSpecification3).extract().response();

		// Post User 3
		RequestSpecification requestSpecification4 = given().spec(requestSpecificationBaseURI).body(
				"{\"id\":\"3\",\"firstName\":\"Gheorghe\",\"lastName\":\"Ioan\",\"phoneNumber\":\"1134214\",\"email\":\"aluifer@solera\"}").when();
		ResponseSpecification responseSpecification4 = new ResponseSpecBuilder().expectStatusCode(200).build();
		Response response4 = requestSpecification4.when().post("http://localhost:8080/users")
				.then().spec(responseSpecification4).extract().response();
		System.out.println(response4);

		// Get User 1
		RequestSpecification requestSpecification2 = given().spec(requestSpecificationBaseURI).when();
		ResponseSpecification responseSpecification2 = new ResponseSpecBuilder().expectStatusCode(200).build();
		Response response2 = requestSpecification2.when().get("http://localhost:8080/users/1")
				.then().spec(responseSpecification2).extract().response();
		System.out.println(response2);

		// Get All Users
		RequestSpecification requestSpecification5 = given().spec(requestSpecificationBaseURI).when();
		ResponseSpecification responseSpecification5 = new ResponseSpecBuilder().expectStatusCode(200).build();
		Response response5 = requestSpecification5.when().get("http://localhost:8080/users")
				.then().spec(responseSpecification5).extract().response();
		System.out.println(response5);
	}
}
