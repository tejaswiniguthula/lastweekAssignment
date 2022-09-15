package com.teja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teja.bean.InventoryItem;
import com.teja.persistence.InventoryDao;
@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDao inventoryDao;
	private List<InventoryItem> items;
	
	public void setItems(List<InventoryItem> items) {
		this.items = items;
	}
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	@Override
	public InventoryItem getInventoryItemByProductCode(String productCode) {
		return inventoryDao.findByCode(productCode);
	}
	@Override
	public InventoryItem updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity) {
		if(inventoryDao.updateQuantityByCode(productCode, availableQuantity)==1)
		     return inventoryDao.findByCode(productCode);
		else
			return new InventoryItem();

		
	}

}
