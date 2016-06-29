package com.wwkj.bean;

/**
 * 鍟嗗搧绫诲埆
 * @author gmx
 *
 */
public class Categoroy {
	private int id;
	private String name;
	private String picUrl;
	private int parentId;
	private boolean isLeafNode;
	private String tag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public boolean isLeafNode() {
		return isLeafNode;
	}
	public void setLeafNode(boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
