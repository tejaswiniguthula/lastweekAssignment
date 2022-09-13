package com.teja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teja.bean.Product;
import com.teja.persistence.CatalogDao;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogDao catalogDao;
	
	@Override
	public List<Product> listAllProducts() {
		return catalogDao.findAll();
	}

	@Override
	public Optional<Product> getProductByCode(String productCode) {
		return catalogDao.findByCode(productCode);
	}

}
