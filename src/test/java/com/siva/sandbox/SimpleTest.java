package com.siva.sandbox;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {
	/**
	 * Constants
	 */
	public static String HOST = "http://rest-test-cases.getsandbox.com";
	public static String API = "/api";
	public static String PATH_HEARTBEAT = "/heartbeat";
	public static String PATH_SAMPLE = "/sample";

	@BeforeClass
	public void checkIfWebServiceIsUp() {
		baseURI = HOST;
		basePath = API;
		
		/**
		 * Check if the Webhost is working through the heartbeat path. 
		 */
		when()
			.get(PATH_HEARTBEAT)
		.then()
			.statusCode(200)
			.body("status", Matchers.equalTo("ok"));
		
	}

	@Test
	public void doSomeThing() {
		/**
		 * Here we are checking the status and also the JSON value.
		 */
		when()
			.get(PATH_SAMPLE)
		.then()
			.body("status", Matchers.equalTo("ok"))
			.body("comments.comment", Matchers.contains("works well"));
	}
}