package com.qa.project.service;

import java.util.List;

import com.qa.project.persistence.domain.Customer;
import com.qa.project.persistence.domain.Items;

@SuppressWarnings("unused")
public interface CrudService <T>{
	
	public List<T> readAll();
	
	void create (T t);
	
	void update(long id, T t);
	
	void delete(long id);
}
