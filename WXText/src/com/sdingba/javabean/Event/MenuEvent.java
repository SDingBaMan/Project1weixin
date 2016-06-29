package com.sdingba.javabean.Event;

public class MenuEvent extends BaseEvent{
	//事件 KEY 值 ,与自定义菜单接口中的key值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
