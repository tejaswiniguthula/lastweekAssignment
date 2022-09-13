package com.teja.service;

import java.util.List;
import java.util.Optional;

import com.teja.bean.Product;

public interface CatalogService {
List<Product> listAllProducts();
Optional<Product> getProductByCode(String productCode);
}
