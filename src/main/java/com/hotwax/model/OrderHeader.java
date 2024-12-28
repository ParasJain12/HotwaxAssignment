package com.hotwax.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "shipping_contact_mech_id")
	private ContactMech shippingContact;

	@ManyToOne
	@JoinColumn(name = "billing_contact_mech_id")
	private ContactMech billingContact;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ContactMech getShippingContact() {
		return shippingContact;
	}

	public void setShippingContact(ContactMech shippingContact) {
		this.shippingContact = shippingContact;
	}

	public ContactMech getBillingContact() {
		return billingContact;
	}

	public void setBillingContact(ContactMech billingContact) {
		this.billingContact = billingContact;
	}

}
