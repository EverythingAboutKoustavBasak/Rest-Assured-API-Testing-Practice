package trello.post.api;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class VerifyPostAPITest {
	
	private final static String baseUrl = "https://api.trello.com";
	private String boardName = "API TESTING FROM RESTASSURED - "+ (int)(Math.random()*100);
	
	@Test(description = "Verify the create board res body")
	public void VerifyResBodyTest() {
		
		RestAssured.baseURI = baseUrl;
		System.out.println(boardName);
		
		
		given()
			.queryParam("key", "5d1f1f7aba0c440afd58cba982a710c9")
			.queryParam("token", "ATTAa098940125aed3ad41c4276c1f728cda9d07a94074060a33577241b6e036be094EB20C48")
			.queryParam("name", boardName)

		.when()
			.post("/1/boards/")
			
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("name", equalTo(boardName),
					"id", notNullValue()
					);		
		
	}
	

}
