package com.teja.demo;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.teja.bean.Product;
import com.teja.persistence.CatalogDao;

@SpringBootApplication(scanBasePackages = "com.teja")
@EntityScan(basePackages = "com.teja.bean")
@EnableJpaRepositories(basePackages = "com.teja.persistence")
public class CatalogueServiceApplication implements CommandLineRunner {

	@Autowired
	private CatalogDao catalogDao;
	public static void main(String[] args) {
		SpringApplication.run(CatalogueServiceApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		catalogDao.save(new Product(101L,"P001","Pen","blue pen",10.0));
		catalogDao.save(new Product(102L,"P002","Pencil","hp pencil",10.0));
		catalogDao.save(new Product(103L,"P003","scale","Natraj Scale",10.0));
		catalogDao.save(new Product(104L,"P004","Eraser","Natraj Eraser",10.0));
		catalogDao.save(new Product(105L,"P005","Sharpner","Apsra Sharpner",10.0));
	}

}
