package com.wwkj.bean;

import java.util.Map;

public class Filter {
	private int id;

	private String key;
	private Map<String, String> value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Map<String, String> getValue() {
		return value;
	}

	public void setValue(Map<String, String> value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
