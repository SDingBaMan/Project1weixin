package com.wwkj.bean;

import java.util.ArrayList;
import java.util.Date; 

public class Product {
	private Long id;
	private Topic topic;
	private Category category;
	private String name;
	private String pic;
	private float marketprice;
	private float price;
	private float limitprice;
	private Long leftTime;
	private int sale;
	private Float score;
	private Date shelves;
	private long commentCount;
	private boolean available;
	private int buyLimit;
	private ArrayList productProm;
	private String inventoryArea;
	private String productdesc;
	public Topic theTopic;
	public Category theCategory;

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public float getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(float marketprice) {
		this.marketprice = marketprice;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getLimitprice() {
		return limitprice;
	}

	public void setLimitprice(float limitprice) {
		this.limitprice = limitprice;
	}

	public Long getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(Long leftTime) {
		this.leftTime = leftTime;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Date getShelves() {
		return shelves;
	}

	public void setShelves(Date shelves) {
		this.shelves = shelves;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getBuyLimit() {
		return buyLimit;
	}

	public void setBuyLimit(int buyLimit) {
		this.buyLimit = buyLimit;
	}

	public ArrayList getProductProm() {
		return productProm;
	}

	public void setProductProm(ArrayList productProm) {
		this.productProm = productProm;
	}

	public String getInventoryArea() {
		return inventoryArea;
	}

	public void setInventoryArea(String inventoryArea) {
		this.inventoryArea = inventoryArea;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public Topic getTheTopic() {
		return theTopic;
	}

	public void setTheTopic(Topic theTopic) {
		this.theTopic = theTopic;
	}

	public Category getTheCategory() {
		return theCategory;
	}

	public void setTheCategory(Category theCategory) {
		this.theCategory = theCategory;
	}
	
}
