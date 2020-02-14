package com.qa.project.service;

import java.util.List;

import com.qa.project.persistence.dao.Dao;
import com.qa.project.persistence.domain.Orders;

public class OrdersService implements CrudService<Orders>{
	Dao<Orders> orderDao;

	public OrdersService(Dao<Orders> orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Orders> readAll() {
		return orderDao.readAll();
	}

	@Override
	public void create(Orders item) {
		orderDao.create(item);
	}

	@Override
	public void update(long id, Orders item) {
		orderDao.update(id, item);
	}

	@Override
	public void delete(long id) {
		orderDao.delete(id);
	}

}
