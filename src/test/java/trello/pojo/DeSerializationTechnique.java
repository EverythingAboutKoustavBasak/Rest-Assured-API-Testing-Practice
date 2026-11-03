package trello.pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeSerializationTechnique {
	
	
	@Test
	public void deserializeJSONToPOJO(){

	    String employeeJSON = "	        {\r\n"
	    		+ "	            \"firstName\": \"Anshul\",\r\n"
	    		+ "	            \"lastName\": \"Chauhan\",\r\n"
	    		+ "	            \"gender\": \"Male\",\r\n"
	    		+ "	            \"age\": 29,\r\n"
	    		+ "	            \"salary\": 123456.0,\r\n"
	    		+ "	            \"married\": false\r\n"
	    		+ "	        }";
	        

	    ObjectMapper objectMapper = new ObjectMapper();

	    EmpPojo employee = null;
		try {
			employee = objectMapper.readValue(
			        employeeJSON,
			        EmpPojo.class
			);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    System.out.println(employee.getFirstName());
	    System.out.println(employee.getLastName());
	    System.out.println(employee.getAge());
	}
	
	
	
	
	/**
	 * 
	 * Deserialization using REST Assured (recommended for API automation).You don't always need to create an ObjectMapper manually. REST Assured can deserialize the API response directly into a POJO.
	 * 
	 * @Test
		public void deserializeAPIResponse() {
		
		    SamplePOJO employee =
		            given()
		            .when()
		                .get("https://your-api.com/employees/101")
		            .then()
		                .statusCode(200)
		                .extract()
		                .as(SamplePOJO.class);
		
		    System.out.println(employee.getFirstName());
		    System.out.println(employee.getAge());
		}
	 * 
	 * 
	 *
	 */
	
	/*
	 * 
	 * Comparison: Serialization vs Deserialization
		Serialization	         |	Deserialization
		Java object → JSON		 |	JSON → Java object
		writeValueAsString()	 |	readValue()
		REST Assured .body(pojo) |	REST Assured .as(POJO.class)
		Mostly used for sending  |	Mostly used for processing response data
	 *  request data
	 * 
	 * 
	 * 
	 */

}
