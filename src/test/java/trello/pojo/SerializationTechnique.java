package trello.pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationTechnique {

	@Test(description = "Testing the Serialization teching")
	public void serializationTest() {
		EmpPojo empPojo = new EmpPojo("Koustav", "Basak", "Male", 25, 25000.00, false);

		// Create ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();

		// Convert POJO into JSON
		String employeeJSON = null;
		try {
			employeeJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empPojo);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(employeeJSON);
	}
	
	/*
	 * Approach 2 - Serialization directly using REST Assured
	 * 
	 * This is particularly useful in API automation. we don't need to manually convert the POJO into a JSON string.
	 * 		@Test
			public void createEmployee() {
			
			    SamplePOJO employee = new SamplePOJO();
			
			    employee.setFirstName("Anshul");
			    employee.setLastName("Chauhan");
			    employee.setGender("Male");
			    employee.setAge(29);
			    employee.setSalary(123456);
			    employee.setMarried(false);
			
			    given()
			        .contentType(ContentType.JSON)
			        .body(employee)
			
			    .when()
			        .post("https://your-api.com/employees")
			
			    .then()
			        .statusCode(201);
			}
	 * 
	 * What happens internally?
		1. You create a Java POJO object.
		2. You pass the object into .body(employee).
		3. REST Assured uses a supported object mapper, such as Jackson.
		4. Jackson converts the POJO into JSON.
		5. REST Assured sends that JSON as the request body.
	 * 
	 * 
	 */
	
	

}
