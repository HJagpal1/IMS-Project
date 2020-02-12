package com.qa.project;

import org.apache.log4j.Logger;

public class ProjecRunner {
	
	public static final Logger LOGGER = Logger.getLogger(ProjecRunner.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProjectIMS ims = new ProjectIMS();
		ims.imsSystem();
	}

}
