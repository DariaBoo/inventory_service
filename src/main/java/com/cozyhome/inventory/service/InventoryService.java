package com.cozyhome.inventory.service;

import java.util.List;
import java.util.Map;

import com.cozyhome.inventory.dto.ProductColorDto;

public interface InventoryService {
	
	int getQuantityByProductColor(ProductColorDto request);
	
	String getQuantityStatusByProductColor(ProductColorDto request);
	
	Map<String, String> getQuantityStatusBySkuCodeList(List<String> productSkuCodeList);
	
	Map<String, String> getColorQuantityStatusBySkuCode(String productSkuCode);
	
}
