package com.qa.project.controller;

import org.apache.log4j.Logger;

import com.qa.project.utils.Utils;

public enum Action {
	CREATE("To save a item into database"), READ("To read an item from database"),
	UPDATE("To change an item within the database"), DELETE("To remove item from database"),
	RETURN("To return to domain selection");
	
	public static Logger LOGGER = Logger.getLogger(Action.class);
	
	private String description;
	
	Action(String description){
		this .description = description;
	}
	
	public String description(){
		return this.name() + ": " + this.description;
	}
	
	public static void printAction(){
		for (Action action : Action.values()){
			LOGGER.info(action.description());
		}
	}
	
	public static Action getAction(){
		Action action;
		while(true){
			try{
			action = Action.valueOf(Utils.getInput().toUpperCase());
			break;
			}catch(IllegalArgumentException e){
				LOGGER.error("Invalid selection");
			}
		}
		return action;
	}
}
