package com.siva.sandbox;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SimpleTest {
	public static String HOST = "http://rest-test-cases.getsandbox.com";
	public static String PATH_HEARTBEAT = "/api/heartbeat";
	public static String PATH_SAMPLE = "/api/sample";

	@BeforeClass
	public void checkIfWebServiceIsUp() {
		/**
		 * Check if the Webhost is working through the heartbeat path. 
		 */
		RestAssured.get(HOST+PATH_HEARTBEAT)
			.then()
				.statusCode(200)
				.body("status", Matchers.equalTo("ok"));
		
	}

	@Test
	public void doSomeThing() {
		/**
		 * Here we are checking the status and also the JSON value.
		 */
		RestAssured.get(HOST + PATH_SAMPLE)
			.then()
				.body("status", Matchers.equalTo("ok"))
				.body("comments.comment", Matchers.contains("works well"));
	}
}