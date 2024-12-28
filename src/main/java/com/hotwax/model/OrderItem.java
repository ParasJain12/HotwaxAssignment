package com.hotwax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemSeqId;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderHeader orderHeader;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false,length = 20)
	private String status;

	public int getOrderItemSeqId() {
		return orderItemSeqId;
	}

	public void setOrderItemSeqId(int orderItemSeqId) {
		this.orderItemSeqId = orderItemSeqId;
	}

	public OrderHeader getOrderHeader() {
		return orderHeader;
	}

	public void setOrderHeader(OrderHeader orderHeader) {
		this.orderHeader = orderHeader;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}