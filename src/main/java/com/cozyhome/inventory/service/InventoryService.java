package com.cozyhome.inventory.service;

import java.util.List;
import java.util.Map;

import com.cozyhome.inventory.dto.ColorQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductColorDto;
import com.cozyhome.inventory.dto.ProductQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductSkuCodeRequest;

public interface InventoryService {
	
//	int getQuantityByProductColor1(ProductColorDto request);
//	
//	List<ProductQuantityStatusDto> getQuantityStatusBySkuCodeList(ProductSkuCodeRequest request);
//	
//	List<ColorQuantityStatusDto> getQuantityStatusBySkuCode(String productSkuCode);
	
	
	
	int getQuantityByProductColor(ProductColorDto request);
	
	String getQuantityStatusByProductColor(ProductColorDto request);
	
	Map<String, String> getQuantityStatusBySkuCodeList(List<String> productSkuCodeList);
	
	List<ColorQuantityStatusDto> getColorQuantityStatusBySkuCode(String productSkuCode);
	
}
