package com.wwkj.bean;

public class baseInfo {
	private String name;
	private String pic;
	private Integer id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "baseInfo [name=" + name + ", pic=" + pic + ", id=" + id + "]";
	}
	
	

}
