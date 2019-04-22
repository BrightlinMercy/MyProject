package com.thecardcottage.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {

	@ManyToOne
	Customer customer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressid;
	
	@Column(nullable = false)
	private String customername;
	
	@Column(nullable = false)
	@NotEmpty(message = "Address Line1 is mandatory")
	private String addline1;
	
	@Column(nullable = false, columnDefinition = "text")
	@NotEmpty(message = "Address Line2 is mandatory")
	private String addline2;
	
	@Column(nullable = false, columnDefinition = "text")
	@NotEmpty(message = "User city is mandatory")
	private String city;
	
	@Column(nullable = false, columnDefinition = "text")
	@NotEmpty(message = "User state is mandatory")
	private String state;

	@Column(nullable = false)
	private int pincode;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAddline1() {
		return addline1;
	}

	public void setAddline1(String addline1) {
		this.addline1 = addline1;
	}

	public String getAddline2() {
		return addline2;
	}

	public void setAddline2(String addline2) {
		this.addline2 = addline2;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
}
