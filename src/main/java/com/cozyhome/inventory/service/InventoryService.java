package com.cozyhome.inventory.service;

import java.util.List;

import com.cozyhome.inventory.dto.ColorQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductColorDto;
import com.cozyhome.inventory.dto.ProductQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductSkuCodeRequest;

public interface InventoryService {
	
	int getQuantityByProductColor(ProductColorDto request);
	
	List<ProductQuantityStatusDto> getQuantityStatusBySkuCodeList(ProductSkuCodeRequest request);
	
	List<ColorQuantityStatusDto> getQuantityStatusBySkuCode(String productSkuCode);
	
}
