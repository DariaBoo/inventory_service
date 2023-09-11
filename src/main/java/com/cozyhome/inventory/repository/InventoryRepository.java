package com.cozyhome.inventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cozyhome.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{	
	
	Optional<Inventory> findByProductColorProductSkuCodeAndProductColorColorHex(String productSkuCode, String colorHex);
	
	List<Inventory> findByProductColorProductSkuCodeIn(List<String> productSkuCodes);
	
	List<Inventory> findByProductColorProductSkuCode(String productSkuCode);

	@Query("SELECT inv.quantity FROM Inventory inv JOIN inv.productColor pc WHERE pc.productSkuCode = ?1 AND pc.colorHex = ?2")
	Optional<Integer> findQuantityByProductSkuCodeAndColorHex(String productSkuCode, String colorHex);

}
