package trello.nastedJsonToPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpPojoClass {
	
	private String firstName; 
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    
    @JsonProperty("Address")
    private EmpAddressPojoClass address;
    
    
	public EmpPojoClass() {
		super();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public EmpAddressPojoClass getAddress() {
		return address;
	}
	public void setAddress(EmpAddressPojoClass address) {
		this.address = address;
	}
    
    

}
