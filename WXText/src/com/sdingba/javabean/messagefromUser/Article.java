package com.sdingba.javabean.messagefromUser;

/**
 * 图片
 * @author su
 *
 */
public class Article {
	//图文消息 名称
	private String Title;
	//消息描叙
	private String Description;
	//图片链接，支持jpg...教好的效果为大图640*320像素，
	//小图 80*80
	private String PicUrl;
	//点击图文消息跳转链接
	private String Url;


	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}

}
