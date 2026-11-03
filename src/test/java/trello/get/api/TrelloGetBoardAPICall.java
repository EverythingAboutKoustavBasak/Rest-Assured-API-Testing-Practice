package trello.get.api;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.*;

public class TrelloGetBoardAPICall {
	
	private final static String baseUrl = "https://api.trello.com";

	public static void main(String[] args) {
		
		
		
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
		
		System.out.println("Test Pass! ");
	
		
		
		

	}

}
