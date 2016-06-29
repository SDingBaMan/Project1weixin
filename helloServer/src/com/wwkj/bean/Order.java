package com.wwkj.bean;

import java.util.Date;

public class Order {

	private int orderId;
	private Address address;
	private Integer userId;
	private Integer paymentType;
	private Integer deliveryType;
	private Integer cartId;
	private Integer logisticsId;
	private double price;
	private String status;
	private String Ordertime;
	private int flag;
	private Integer invoiceId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(Integer logisticsId) {
		this.logisticsId = logisticsId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrdertime() {
		return Ordertime;
	}

	public void setOrdertime(String ordertime) {
		Ordertime = ordertime;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	

}
