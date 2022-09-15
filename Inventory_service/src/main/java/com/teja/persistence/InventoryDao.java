package com.teja.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teja.bean.InventoryItem;



@Repository
public interface InventoryDao extends JpaRepository<InventoryItem, Long>{

	@Query(value="from InventoryItem where productCode=:code")
	InventoryItem findByCode(@Param("code") String code);
	
	@Modifying
	@Transactional
	@Query(value="Update InventoryItem set availableQuantity=:quan where productCode=:code",nativeQuery = true)
	int updateQuantityByCode(@Param("code") String code,@Param("quan") int quan);
}
