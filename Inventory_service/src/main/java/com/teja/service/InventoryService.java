package com.teja.service;

import com.teja.bean.InventoryItem;

public interface InventoryService {

	InventoryItem getInventoryItemByProductCode(String productCode);
	InventoryItem updateInventoryItemQuantityByProductCode(String productCode,int availableQuantity);
}
