package trello.nastedJsonToPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpAddressPojoClass {
	
	/**
	 * 
	 * {
		    "Address": {
		        "Street": "Park Avenue",
		        "City": "Vijayawada",
		        "State": "Andhra Pradesh",
		        "pin code": 530012
		    }
		}
	 * 
	 * 
	 */
	
	@JsonProperty("Street")
	private String street;
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("State")
	private String state;
	
	@JsonProperty("pin code")
	private int pinCode;
	
	
	public EmpAddressPojoClass() {
		super();
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
	

}
