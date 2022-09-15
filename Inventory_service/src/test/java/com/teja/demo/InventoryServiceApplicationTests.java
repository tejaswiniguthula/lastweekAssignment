package com.teja.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teja.bean.InventoryItem;
import com.teja.persistence.InventoryDao;
import com.teja.service.InventoryServiceImpl;

@SpringBootTest
class InventoryServiceApplicationTests {

	@Autowired
    private InventoryServiceImpl inventoryService;
	
	@Autowired
	private InventoryDao inventoryDao;;
	private InventoryDao inventoryDao2;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		inventoryService=new InventoryServiceImpl();
		 inventoryService.setInventoryDao(inventoryDao);
		
		 
		 inventoryDao2=Mockito.mock(InventoryDao.class);
			
			List<InventoryItem> items=new ArrayList<InventoryItem>();
			items.add(new InventoryItem(1001L, "Item001", 20));	
			items.add(new InventoryItem(1002L, "Item002", 30));
			items.add(new InventoryItem(1003L, "Item003", 40));
			
			
			inventoryService.setItems(items);
			inventoryService.setInventoryDao(inventoryDao2);
	}

	@AfterEach
	public void tearDown() throws Exception {
		inventoryService=null;
	}

	@Test
	void R001_T001() {
        InventoryItem p=new InventoryItem(1001L, "Item001", 20);
		Mockito.when(inventoryService.getInventoryItemByProductCode("Item001")).thenReturn(p);
		assertEquals(p,inventoryService.getInventoryItemByProductCode("Item001"));	
	}
	@Test
	void R001_T002() {
       // InventoryItem p=new InventoryItem(1001L, "Item001", 20);
		Mockito.when(inventoryService.getInventoryItemByProductCode("Item008")).thenReturn(null);
		assertEquals(null,inventoryService.getInventoryItemByProductCode("Item008"));	
	}
	@Test
	void R001_T003() {
        InventoryItem p=new InventoryItem(1001L, "Item001", 30);
		Mockito.when(inventoryService.updateInventoryItemQuantityByProductCode("Item001",30)).thenReturn(p);
		assertEquals(p, inventoryService.updateInventoryItemQuantityByProductCode("Item001",30));
		//assertEquals(p,inventoryService.updateInventoryItemQuantityByProductCode("Item001",30));	
	}
	@Test
	void R001_T004() {
		
		InventoryItem p=new InventoryItem();
		Mockito.when(inventoryService.updateInventoryItemQuantityByProductCode("Item006",90)).thenReturn(p);
		assertEquals(p,inventoryService.updateInventoryItemQuantityByProductCode("Item006",90));	
	}
	
	
	
	
	
	@Test()
	public void R002_T001(){
		InventoryItem p=new InventoryItem(1001L,"Item001",20);
		assertEquals(p,inventoryDao.findByCode("Item001"));	
	}
	
	@Test()
	public void R002_T002(){
		//InventoryItem p=new InventoryItem(1001L,"Item001",20);
		assertEquals(null,inventoryDao.findByCode("Item006"));	
	}
	
	@Test()
	public void R002_T003(){
		InventoryItem p=new InventoryItem(1001L,"Item001",30);
		assertEquals(1, inventoryDao.updateQuantityByCode("Item001",30));
		//assertEquals(1,inventoryDao.updateQuantityByCode("Item001",30));	
	}
	@Test()
	public void R002_T004(){
		//InventoryItem p=new InventoryItem(1001L,"Item001",30);
		assertEquals(0,inventoryDao.updateQuantityByCode("Item009",30));	
	}
}
