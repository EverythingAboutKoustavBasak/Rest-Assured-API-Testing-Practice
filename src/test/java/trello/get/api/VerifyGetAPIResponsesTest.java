package trello.get.api;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class VerifyGetAPIResponsesTest {
	
	private final static String baseUrl = "https://api.trello.com";

	@Test(description = "Verify the Get board res body")
	public void VerifyResBodyTest() {
		
		RestAssured.baseURI = baseUrl;
		
		given()
			.param("key", "5d1f1f7aba0c440afd58cba982a710c9")
			.param("token", "ATTAa098940125aed3ad41c4276c1f728cda9d07a94074060a33577241b6e036be094EB20C48")

		.when()
			.get("/1/boards/mtjRMsuI")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("name", equalTo("Project-1"),
					"id", notNullValue(),
					"desc", equalTo("**Created by Koustav on 26 oct 2026**")
					);		
		
	}
	
	@Test(description = "Verify the Get board res headers")
	public void VerifyResHeaderTest() {
		
		RestAssured.baseURI = baseUrl;
		
		given()
		.param("key", "5d1f1f7aba0c440afd58cba982a710c9")
		.param("token", "ATTAa098940125aed3ad41c4276c1f728cda9d07a94074060a33577241b6e036be094EB20C48")
		
		.when()
		.get("/1/boards/mtjRMsuI")
		.then()
		.headers("X-Trello-Environment", equalTo("Production"),
				 "Content-Type", equalTo("application/json; charset=utf-8")	
				);	
		
		System.out.println("Test Pass! ");
		
		
		
		
		
	}

}
