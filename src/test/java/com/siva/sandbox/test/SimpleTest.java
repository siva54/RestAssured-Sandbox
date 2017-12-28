package com.siva.sandbox.test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.siva.sandbox.exception.ApplicationAssertionException;
import com.siva.sandbox.helper.AssertUtils;

import io.restassured.response.Response;

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
		when().get(PATH_HEARTBEAT).then().statusCode(200).body("status", equalTo("ok"));
	}

	@Test(groups = { "Regression1" })
	public void doSimpleTest() {
		/**
		 * Here we are checking the status and also the JSON value.
		 */
		when().get(PATH_SAMPLE).then().body("status", equalTo("ok")).body("comments.comment",
				contains("works well", "is reliable"));
	}

	@Test(groups = { "Regression2" })
	public void doJSONCompareTest() {
		/**
		 * Here we are comparing the actual JSON with the existing JSON.
		 */
		Response response = when().get(PATH_SAMPLE).then().extract().response();

		try {
			AssertUtils.compareJSON("sample_1.json", response.asString());
		} catch (ApplicationAssertionException e) {
			Assert.fail(e.getMessage());
		}
	}
}