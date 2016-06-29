package com.wwkj.bean;

import java.util.List;

public class City {
	Integer id;
	String value;
	List<Area> areas;
	
	public City(Integer id, String value, List<Area> areas) {
		super();
		this.id = id;
		this.value = value;
		this.areas = areas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Area> getAreas() {
		return areas;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	
}
