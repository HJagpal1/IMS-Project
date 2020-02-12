package com.qa.project.persistence.domain;

public class Items {
	private Long itemId;
	private String itemName;
	private int value;
	
	public Items(String items, int cost) {
		this.itemName = items;
		this.value = cost;
	}
	
	public Items(Long itemId, String items, int cost) {
		this.itemId = itemId;
		this.itemName = items;
		this.value = cost;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return "ID : " + itemId + " Item Name : " + itemName + " Item Cost : " + value;
	}
}
