package com.wwkj.bean;

/**
 * 商品图片
 * 
 * @author YUY
 * 
 */
public class Pic {
	private int id;
	private String url;
	private int type;
	private Prod product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Prod getProduct() {
		return product;
	}

	public void setProduct(Prod product) {
		this.product = product;
	}

}
