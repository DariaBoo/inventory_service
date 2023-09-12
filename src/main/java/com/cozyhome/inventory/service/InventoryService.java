package com.cozyhome.inventory.service;

import java.util.List;
import java.util.Map;

import com.cozyhome.inventory.dto.InventoryForBasketDto;
import com.cozyhome.inventory.dto.ProductColorDto;
import com.cozyhome.inventory.dto.QuantityStatusDto;

public interface InventoryService {
	
	int getQuantityByProductColor(ProductColorDto request);
	
	String getQuantityStatusByProductColor(ProductColorDto request);
	
	Map<String, String> getQuantityStatusBySkuCodeList(List<String> productSkuCodeList);
	
	QuantityStatusDto getProductCardColorQuantityStatus(String productSkuCode);

	List<InventoryForBasketDto> getProductAvailableStatus(List<ProductColorDto> productColorDto);
	
}
