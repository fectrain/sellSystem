package com.homework.sellSystem.entity;

import java.sql.Blob;

public class Content {

	private int id;
	private Long price;
	private String title;
	
	private Blob icon;
	private String _abstract;
	private Blob text;
	
	public String get_abstract() {
		return _abstract;
	}
	public Blob getIcon() {
		return icon;
	}
	public int getId() {
		return id;
	}
	public Long getPrice() {
		return price;
	}
	public Blob getText() {
		return text;
	}
	public String getTitle() {
		return title;
	}
	public void set_abstract(String _abstract) {
		this._abstract = _abstract;
	}
	public void setIcon(Blob icon) {
		this.icon = icon;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public void setText(Blob text) {
		this.text = text;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
