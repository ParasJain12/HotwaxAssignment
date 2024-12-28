package com.hotwax.dto;

import java.util.Date;
import java.util.List;

public class OrderRequest {

	private Date orderDate;
	private int customerId;
	private int shippingContactId;
	private int billingContactId;
	private List<OrderItemRequest> orderItems;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getShippingContactId() {
		return shippingContactId;
	}

	public void setShippingContactId(int shippingContactId) {
		this.shippingContactId = shippingContactId;
	}

	public int getBillingContactId() {
		return billingContactId;
	}

	public void setBillingContactId(int billingContactId) {
		this.billingContactId = billingContactId;
	}

	public List<OrderItemRequest> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemRequest> orderItems) {
		this.orderItems = orderItems;
	}

}
