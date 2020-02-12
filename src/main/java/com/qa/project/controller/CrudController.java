package com.qa.project.controller;

public interface CrudController<T> {
	void readAll();
	
	void create();
	
	void update();
	
	void delete();
}
