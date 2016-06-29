package com.sdingba.javabean;

public class Token {

	//接口访问的凭证
	private String accessToken;
	/**
	 * 有效凭证，时间，单位 秒
	 */
	private int expiresIn;
	/**
	 * //接口访问的凭证
	 * @return
	 */
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}



}
