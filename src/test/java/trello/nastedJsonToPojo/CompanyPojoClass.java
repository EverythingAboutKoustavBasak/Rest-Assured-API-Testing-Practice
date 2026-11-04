package trello.nastedJsonToPojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyPojoClass {
	
	
	private String companyName;
	
	@JsonProperty("Street")
    private String companyStreet;
	
	@JsonProperty("City")
    private String companyCity;
	
	@JsonProperty("State")
    private String companyState;
	
	@JsonProperty("pin code")
    private int companyPinCode;
	
	@JsonProperty("BankAccounts")
	private List<String> bankAccounts;
	
	private List<EmpPojoClass> employess;

	public CompanyPojoClass() {
		super();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyStreet() {
		return companyStreet;
	}

	public void setCompanyStreet(String companyStreet) {
		this.companyStreet = companyStreet;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	

	public int getCompanyPinCode() {
		return companyPinCode;
	}

	public void setCompanyPinCode(int companyPinCode) {
		this.companyPinCode = companyPinCode;
	}

	public List<String> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<String> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<EmpPojoClass> getEmployess() {
		return employess;
	}

	public void setEmployess(List<EmpPojoClass> employess) {
		this.employess = employess;
	}
	
	

}
