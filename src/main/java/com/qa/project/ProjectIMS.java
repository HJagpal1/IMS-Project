package com.qa.project;

import org.apache.log4j.Logger;

import com.qa.project.controller.Action;
import com.qa.project.controller.CrudController;
import com.qa.project.controller.CustomerController;
import com.qa.project.controller.ItemsController;
import com.qa.project.persistence.dao.MysqlCustomerDao;
import com.qa.project.persistence.dao.MysqlItemDao;
import com.qa.project.persistence.domain.Domain;
import com.qa.project.service.CustomerService;
import com.qa.project.service.ItemsService;
import com.qa.project.utils.Configuration;
import com.qa.project.utils.Utils;

public class ProjectIMS {

	public static final Logger LOGGER = Logger.getLogger(ProjectIMS.class);

	public void imsSystem() {
		LOGGER.info("Please enter your username : ");
		Configuration.username = Utils.getInput();
		LOGGER.info("Please enter your password :");
		Configuration.password = Utils.getInput();

		LOGGER.info ("What entity would you like? ");
		Domain.printDomains();

		Domain domain = Domain.getDomain();
		LOGGER.info("What you like to do with this: " + domain.name().toLowerCase() + ":");

		Action.printAction();
		Action action = Action.getAction();

		switch(domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(new CustomerService(new MysqlCustomerDao()));
			doAction(customerController, action);
		case ITEM: ItemsController itemsController = new ItemsController(new ItemsService(new MysqlItemDao()));
		doAction(itemsController, action);
		break;
		case ORDER:
			break;
		case STOP:
			break;
		}

	}
	
	public void doAction(CrudController<?> crudController, Action action) {
		switch(action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
		case DELETE: 
			crudController.delete();
			break;
		case RETURN:
			break;
			
		}
	}
	
}
