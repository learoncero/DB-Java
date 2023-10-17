package northwind.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String _street;
	private String _city;
	private String _region;
	private String _postalCode;
	private String _country;
	
	public Address() {
		
	}
	
	public Address(String street, String city, String region, String postalCode, String country) {
		_street = street;  
		_city = city;    
		_region = region;  
		_postalCode = postalCode;
		_country = country; 
	}
	
	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getRegion() {
		return _region;
	}

	public void setRegion(String region) {
		_region = region;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}
}
