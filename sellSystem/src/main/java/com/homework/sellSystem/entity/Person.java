package com.homework.sellSystem.entity;

public class Person {

	private int id;
	private String userName;
	private String password;
	private String nickName;
	private int userType;
	
	public int getId() {
		return id;
	}
	public String getNickName() {
		return nickName;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	public int getUserType() {
		return userType;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
}
