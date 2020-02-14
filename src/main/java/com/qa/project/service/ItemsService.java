package com.qa.project.service;

import java.util.List;

import com.qa.project.persistence.dao.Dao;
import com.qa.project.persistence.domain.Items;

public class ItemsService implements CrudService<Items>{
	Dao<Items> itemDao;

	public ItemsService(Dao<Items> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Items> readAll() { 
		return itemDao.readAll();
	}

	@Override
	public void create(Items item) {
		itemDao.create(item);
	}

	@Override
	public void update(long id, Items item) {
		itemDao.update(id, item);
	}

	@Override
	public void delete(long id) {
		itemDao.delete(id);
	}

}
