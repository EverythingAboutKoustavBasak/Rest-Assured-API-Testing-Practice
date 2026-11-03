package trello.jsonResponseValidation;

import static io.restassured.RestAssured.given;

import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandleJsonStructure {

	private final static String baseUrl = "https://api.trello.com";

	@Test(description = "Verify the Get board res body")
	public void VerifyResBodyTest() {

		RestAssured.baseURI = baseUrl;

		Response res = 
				given()
					.param("key", "5d1f1f7aba0c440afd58cba982a710c9")
					.param("token", "ATTAa098940125aed3ad41c4276c1f728cda9d07a94074060a33577241b6e036be094EB20C48")

				.when()
					.get("/1/boards/mtjRMsuI");

//		.then()
//			.statusCode(200)
//			.contentType(ContentType.JSON)
//			.body("name", equalTo("Project-1"),
//					"id", notNullValue(),
//					"desc", equalTo("**Created by Koustav on 26 oct 2026**")
//					);	
		System.out.println(res.jsonPath().getString("id"));
		System.out.println(res.jsonPath().getString("prefs.backgroundBottomColor"));
		System.out.println(res.jsonPath().getString("prefs.switcherViews[2].viewType"));
		
		//traverse switcherViews json array
		int switchViewsArraySize = res.jsonPath().getInt("prefs.switcherViews.size()");
		System.out.println(switchViewsArraySize);
		
		for (int i = 0; i < switchViewsArraySize; i++) {
			System.out.println(res.jsonPath().getString("prefs.switcherViews["+i+"].viewType"));
			System.out.println(res.jsonPath().getString("prefs.switcherViews["+i+"].enabled"));
			System.out.println("------------------------------------------------");
		}
				
	}

}
