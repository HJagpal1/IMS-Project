package com.qa.project.persistence.domain;

public class Customer {
	private Long id;
	private String name;
	
	public Customer(String firstname) {
		this.name = firstname;
	}
	
	public Customer(Long id, String firstname) {
		this.id = id;
		this.name = firstname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return name;
	}

	public void setFirstname(String firstname) {
		this.name = firstname;
	}
	
	public String toString() {
		return "ID : " + id + " --> " + " Name : " +  name;
	}
	
	
}
