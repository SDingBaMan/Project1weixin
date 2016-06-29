package com.wwkj.bean;

import java.util.List;

public class Logistics {
	private String logisticsid;
	private String logisticscorp;
	private String expressway;
	private int id;
	private List<String> list;
	private Long orderid; 
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public String getLogisticsid() {
		return logisticsid;
	}
	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}
	public String getLogisticscorp() {
		return logisticscorp;
	}
	public void setLogisticscorp(String logisticscorp) {
		this.logisticscorp = logisticscorp;
	}
	public String getExpressway() {
		return expressway;
	}
	public void setExpressway(String expressway) {
		this.expressway = expressway;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	

}
