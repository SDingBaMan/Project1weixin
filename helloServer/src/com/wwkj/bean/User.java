package com.wwkj.bean;

public class User {
	private int userId;
	private String username;
	private String password;
	private int bonus;
	private String level;
	private int ordercount;
	private int favoritescount;
	private String usersession;

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}

	public int getFavoritescount() {
		return favoritescount;
	}

	public void setFavoritescount(int favoritescount) {
		this.favoritescount = favoritescount;
	}

	public String getUsersession() {
		return usersession;
	}

	public void setUsersession(String usersession) {
		this.usersession = usersession;
	}

}
