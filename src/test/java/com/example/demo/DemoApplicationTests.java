package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;
@SpringBootTest
class DemoApplicationTests {

	String baseurl= "http://localhost:8081";



	@Test
	void getgreeting() throws JSONException {
		RestAssured.baseURI = baseurl;
		// Get the RequestSpecification of the request to be sent to the server.
		RequestSpecification httpRequest = RestAssured.given();
		// specify the method type (GET) and the parameters if any.
		//In this case the request does not take any parameters
		httpRequest.param("name", "Kavya");
		Response response = httpRequest.get("/greeting");

		// Print the status and message body of the response received from the server
		System.out.println("Status received => " + response.getStatusLine());


	}

	@Test
	void postgreeting() throws JSONException {
		RestAssured.baseURI = baseurl;
		// Get the RequestSpecification of the request to be sent to the server.
		RequestSpecification httpRequest = RestAssured.given();
		// specify the method type (GET) and the parameters if any.
		//In this case the request does not take any parameters
		httpRequest.param("name", "lakdfjsöldkfösdlkföljkfsdölBORNA");
		Response response = httpRequest.post("/data/5000");

		// Print the status and message body of the response received from the server
		System.out.println("Status received => " + response.getStatusLine());
		System.out.println(response);


	}

	@Test
	void getdata() throws JSONException {
		RestAssured.baseURI = baseurl;
		// Get the RequestSpecification of the request to be sent to the server.
		RequestSpecification httpRequest = RestAssured.given();
		// specify the method type (GET) and the parameters if any.
		Response response = httpRequest.get("/data");

		// Print the status and message body of the response received from the server
		System.out.println("Status received => " + response.getStatusLine());
		System.out.println(response.prettyPrint());


	}



}
