package trello.nastedJsonToPojo;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostCallUsingPayload {
	
	@Test
	public void createUser() {
		
		
		//create req payload
		CompanyPojoClass company = new CompanyPojoClass();
		
		company.setCompanyName("Cognizant");
		company.setCompanyStreet("Candor, Section Area - 1");
		company.setCompanyCity("New Town");
		company.setCompanyState("West Bengal");
		company.setCompanyPinCode(700022);
		
		
		List<String> bankAccounts = new ArrayList<>();
		bankAccounts.add("HDFC");
		bankAccounts.add("Kotak");
		
		company.setBankAccounts(bankAccounts);
		
		
		EmpPojoClass emp1 = new EmpPojoClass();
		EmpPojoClass emp2 = new EmpPojoClass();
		EmpPojoClass emp3 = new EmpPojoClass();
		
		
		//emp1
		emp1.setFirstName("Koustav");
		emp1.setLastName("Basak");
		emp1.setGender("Male");
		emp1.setAge(25);
		emp1.setSalary(25000.00);
		
		//emp1 address
		EmpAddressPojoClass emp1Address = new EmpAddressPojoClass();
		emp1Address.setStreet("Kankurachi");
		emp1Address.setCity("Kolkata");
		emp1Address.setState("WB");
		emp1Address.setPinCode(700054);
		
		emp1.setAddress(emp1Address);
		
		//emp2
		emp2.setFirstName("Koustav");
		emp2.setLastName("Basak");
		emp2.setGender("Male");
		emp2.setAge(25);
		emp2.setSalary(25000.00);
		
		//emp2 address
		EmpAddressPojoClass emp2Address = new EmpAddressPojoClass();
		emp2Address.setStreet("Kankurachi");
		emp2Address.setCity("Kolkata");
		emp2Address.setState("WB");
		emp2Address.setPinCode(700054);
		
		emp2.setAddress(emp1Address);
		
		
		//emp3
		emp3.setFirstName("Koustav");
		emp3.setLastName("Basak");
		emp3.setGender("Male");
		emp3.setAge(25);
		emp3.setSalary(25000.00);
		
		//emp3 address
		EmpAddressPojoClass emp3Address = new EmpAddressPojoClass();
		emp3Address.setStreet("Kankurachi");
		emp3Address.setCity("Kolkata");
		emp3Address.setState("WB");
		emp3Address.setPinCode(700054);
		
		emp3.setAddress(emp1Address);
		
		
		
		List<EmpPojoClass> empList = new ArrayList<EmpPojoClass>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		
		company.setEmployess(empList);
		
		
		
		//convert pojo object to json object as string - serialization
		ObjectMapper objectMapper = new ObjectMapper();
		String reqPayload = null;
		try {
			reqPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(company);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("--------Req Payload Body--------");
		System.out.println(reqPayload);
		
		//post call
		Response res = given()
			.contentType(ContentType.JSON)
			.body(company)
		.when()
			.post("http://httpbin.org/post");
			
		
		Assert.assertEquals(res.statusCode(), 200);	
		
		System.out.println("--------Res Body--------");
		res.prettyPrint();
		
	}
	

}
