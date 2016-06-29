package com.wwkj.bean;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int id;
	private int totalCount;
	private float totalPrice;
	private float totalPoint;
	private List<String> proms = new ArrayList<String>();
	 
	private List<CartItem> cartitem;
	
	
	public List<CartItem> getCartitem() {
		return cartitem;
	}
	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public float getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(float totalPoint) {
		this.totalPoint = totalPoint;
	}
	public List<String> getProms() {
		return proms;
	}
	public void setProms(List<String> proms) {
		this.proms = proms;
	}
	

}
