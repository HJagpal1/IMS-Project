package com.qa.project.persistence.domain;

public class Items {
	private Long itemId;
	private String itemName;
	private Long value;
	
	public Items(String items, Long cost) {
		this.itemName = items;
		this.value = cost;
	}
	
	public Items(Long itemId, String items, Long cost) {
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

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
	public String toString() {
		return "ID : " + itemId + " Item Name : " + itemName + " Item Cost : " + value;
	}
}
