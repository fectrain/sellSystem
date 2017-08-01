package com.homework.sellSystem.entity;

public class Transaction {

	private int id;
	private int contentId;
	private int personId;
	private int price;
	private Long time;
	
	public int getContentId() {
		return contentId;
	}
	public int getId() {
		return id;
	}
	public int getPersonId() {
		return personId;
	}
	public int getPrice() {
		return price;
	}
	public Long getTime() {
		return time;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTime(Long time) {
		this.time = time;
	}
}
