package com.sdingba.javabean.messagefromUser;

public class Video {
	//mei ti wenjian 
	private String MediaId;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	//缩略图的媒体文件ID
	private String ThumbMediaId;
}
