package com.teja.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teja.bean.Product;
@Repository
public interface CatalogDao extends JpaRepository<Product, Long>{
	
	@Query(value="from Product where code=:code")
	Optional<Product> findByCode(@Param("code") String code);
}
