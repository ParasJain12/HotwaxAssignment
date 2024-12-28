package com.hotwax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContactMech {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactMechId;
	
	@Column(nullable=false,length = 100)
	private String streetAddress;
	
	@Column(nullable=false,length = 50)
	private String city;
	
	@Column(nullable=false,length = 50)
	private String state;
	
	@Column(nullable=false,length = 20)
	private String postalCode;
	
	@Column(length = 20)
	private String phoneNumber;
	
	@Column(length = 100)
	private String email;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public int getContactMechId() {
		return contactMechId;
	}

	public void setContactMechId(int contactMechId) {
		this.contactMechId = contactMechId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
