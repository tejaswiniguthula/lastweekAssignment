package com.teja.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teja.bean.InventoryItem;
import com.teja.service.InventoryService;

@RestController
public class InventoryResource {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping(path = "/inventories/{code}",produces = MediaType.APPLICATION_JSON_VALUE )
	public InventoryItem getByCodeResource(@PathVariable("code") String code) {
		InventoryItem item=inventoryService.getInventoryItemByProductCode(code);
		if(item!=null)
			return item;
		else
			return new InventoryItem();
	}

	@PutMapping(path = "/inventories/{code}/{quan}",produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryItem updateQuantityByCode(@PathVariable("code") String code,@PathVariable("quan") int quan)
	{
		InventoryItem item=inventoryService.updateInventoryItemQuantityByProductCode(code, quan);
		if(item!=null)
			return item;
		else
			return new InventoryItem();
	}
}
