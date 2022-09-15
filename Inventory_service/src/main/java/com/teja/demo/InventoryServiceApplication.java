package com.teja.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.teja.bean.InventoryItem;
import com.teja.persistence.InventoryDao;

@SpringBootApplication(scanBasePackages = "com.teja")
@EntityScan(basePackages = "com.teja.bean")
@EnableJpaRepositories(basePackages = "com.teja.persistence")
@EnableEurekaClient
public class InventoryServiceApplication implements CommandLineRunner{

	@Autowired
	private InventoryDao inventoryDao;
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inventoryDao.save(new InventoryItem(1001L,"Item001",20));
		inventoryDao.save(new InventoryItem(1002L,"Item002",30));
		inventoryDao.save(new InventoryItem(1003L,"Item003",40));
		inventoryDao.save(new InventoryItem(1004L,"Item004",50));
		inventoryDao.save(new InventoryItem(1005L,"Item005",60));

	}

}
