package com.wwkj.bean;

import java.util.List;

public class Province {
	Integer id;
	String value;
	List<City> citys;
	public Province(Integer id, String value, List<City> citys) {
		super();
		this.id = id;
		this.value = value;
		this.citys = citys;
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
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

}
