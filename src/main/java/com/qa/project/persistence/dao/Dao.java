package com.qa.project.persistence.dao;

import java.util.ArrayList;

public interface Dao<T> {
	public ArrayList<T>readAll();
		
	public void create(T t);
		
	void update(long id , T t);
		
	void delete(long id);
	
}
