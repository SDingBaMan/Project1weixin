package com.sdingba.javabean.messagefromUser;
/**
 * 公共账号 --> 普通用户
 * @author su
 *
 */
public class BaseMessage {

	/**
	 * 接受方 的账号 （收到的openId）
	 */
	private String ToUserName;
	/**
	 * 发送着的微信号
	 */
	private String FromUserName;
	/**
	 * 消息创建时间 （整形）
	 */
	private long CreateTime;
	/**
	 * 消息类型 （text , image ,location,link,voice）
	 */
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}



}
