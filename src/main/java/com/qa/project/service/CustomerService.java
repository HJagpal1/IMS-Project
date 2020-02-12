package com.qa.project.service;

import java.util.List;

import com.qa.project.persistence.dao.Dao;
import com.qa.project.persistence.domain.Customer;

public class CustomerService implements CrudService<Customer> {
	Dao<Customer> customerDao;

	public CustomerService(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	@Override
	public void update(long id, Customer customer) {
		customerDao.update(id, customer);
	}

	@Override
	public void delete(long id) {
		customerDao.delete(id);
	}

}
