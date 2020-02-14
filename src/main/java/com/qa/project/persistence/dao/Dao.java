package com.qa.project.persistence.dao;

import java.util.List;

public interface Dao<T> {
	public List<T>readAll();
		
	public void create(T t);
		
	void update(long id , T t);
		
	void delete(long id);
	
}
