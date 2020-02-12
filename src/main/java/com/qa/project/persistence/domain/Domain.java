package com.qa.project.persistence.domain;

import org.apache.log4j.Logger;

import com.qa.project.utils.Utils;

public enum Domain {

		CUSTOMER (""),
		ITEM(""),
		ORDER(""),
		STOP("");
		 
	public static final Logger LOGGER = Logger.getLogger(Domain.class);
	private String description;
	
	private Domain(String description){
		this.description = description;
	}
	
	public String description(){
		return this.name() + ": " +description;
	}
	
	public static Domain getDomain() {
		// TODO Auto-generated method stub
		Domain domain;
		while(true){
			try{
				domain = Domain.valueOf(Utils.getInput().toUpperCase());
				break;
			}catch(IllegalArgumentException e){
				LOGGER.error("Invalid Selection");
			}
			
		}
		return domain;
	}

	public static void printDomains() {
		// TODO Auto-generated method stub
		for (Domain domain : Domain.values()){
			LOGGER.info(domain.description());
		}
	}
	

}

