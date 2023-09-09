package com.cozyhome.inventory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cozyhome.inventory.dto.ColorQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductColorDto;
import com.cozyhome.inventory.model.Inventory;
import com.cozyhome.inventory.model.enums.ProductQuantityStatus;
import com.cozyhome.inventory.repository.InventoryRepository;
import com.cozyhome.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
	private final InventoryRepository inventoryRepository;
	private final ModelMapper modelMapper;	
	
	@Override
	public int getQuantityByProductColor(ProductColorDto request) {
		int quantity = -1;
		Optional<Inventory> inventory = inventoryRepository.findByProductColorProductSkuCodeAndProductColorColorHex(
				request.getProductSkuCode(), request.getColorHex());
		if (inventory.isPresent()) {
			quantity = inventory.get().getQuantity();
			log.info("GET QUANTITY [" + quantity + "] for product skuCode [" + request.getProductSkuCode()
					+ "] and color hex [" + request.getColorHex() + "].");
		}
		return quantity;
	}

	@Override
	public String getQuantityStatusByProductColor(ProductColorDto request) {
		int productQuantity = getQuantityByProductColor(request);
		return convertQuantityToQuantityStatus(productQuantity);
	}

	@Override
	public Map<String, String> getQuantityStatusBySkuCodeList(List<String> productSkuCodeList) {
		List<Inventory> inventoryList = inventoryRepository
				.findByProductColorProductSkuCodeIn(productSkuCodeList);
		Map<String, String> map = new HashMap<>();
		for(Inventory inventory : inventoryList) {
			String productSkuCode = inventory.getProductColor().getProductSkuCode();
			String quantityStatus = convertQuantityToQuantityStatus(inventory.getQuantity());
			map.put(productSkuCode, quantityStatus);
		}
		return map;
	}

	private String convertQuantityToQuantityStatus(int productQuantity) {
		 String status = ProductQuantityStatus.getStatusByQuantity(productQuantity);
		 log.info("QUANTITY STATUS [" + status + "] FOR QUANTITY " + productQuantity);
		 return status;
	}

	@Override
	public List<ColorQuantityStatusDto> getColorQuantityStatusBySkuCode(String productSkuCode) {
		List<Inventory> inventoryList = inventoryRepository.findByProductColorProductSkuCode(productSkuCode);
		log.info("Get inventory list [size:" + inventoryList.size());
		return inventoryList.stream().map(this::map).toList();
	}

	private ColorQuantityStatusDto map(Inventory inventory) {
		ColorQuantityStatusDto dto = new ColorQuantityStatusDto();
		dto.setColorHex(inventory.getProductColor().getColorHex());
		dto.setQuantityStatus(ProductQuantityStatus.getStatusByQuantity(inventory.getQuantity()));
		return dto;
	}
}
