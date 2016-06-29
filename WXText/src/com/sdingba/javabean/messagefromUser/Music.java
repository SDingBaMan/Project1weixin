package com.sdingba.javabean.messagefromUser;

public class Music {
	private String Title;
	//描叙
	private String Description;
	//音乐；链接
	private String MusicUrl;
	//高质量音乐链接，在在wifi下，
	private String HQMusicUrl;
	//缩略图的媒体ID 通过上传多媒体文件得到ID
	private String ThumbMediaId;
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
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
