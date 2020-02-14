package com.qa.project.persistence.domain;

public class Orders {
	private Long OrderId;
	private Customer customer;
	private Items items;
	
	public Orders(Customer customer, Items items ) {
		this.customer = customer;
		this.setItems(items);
	}
	
	public Orders(Long OrderId, Customer customer ) {
		this.OrderId = OrderId;
		this.customer = customer;
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	
}
