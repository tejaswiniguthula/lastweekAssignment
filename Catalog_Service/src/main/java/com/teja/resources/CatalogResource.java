package com.teja.resources;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teja.bean.Product;
import com.teja.bean.ProductList;
import com.teja.service.CatalogService;

@RestController
public class CatalogResource {
	
	@Autowired
	private CatalogService catalogService;
	
	
	@GetMapping(path = "/catalogs",produces = MediaType.APPLICATION_JSON_VALUE )
	public ProductList getAllCatalogsResource() {
		return new ProductList(catalogService.listAllProducts());
	}
	
	@GetMapping(path = "/catalogs/{code}",produces = MediaType.APPLICATION_JSON_VALUE )
	public Optional<Product> getByCodeResource(@PathVariable("code") String code) {
		return catalogService.getProductByCode(code);
	}

}
