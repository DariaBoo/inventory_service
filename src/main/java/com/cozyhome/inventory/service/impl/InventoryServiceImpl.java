package com.cozyhome.inventory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cozyhome.inventory.dto.ColorQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductColorDto;
import com.cozyhome.inventory.dto.ProductQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductSkuCodeRequest;
import com.cozyhome.inventory.model.Inventory;
import com.cozyhome.inventory.model.enums.ProductQuantityStatus;
import com.cozyhome.inventory.repository.InventoryRepository;
import com.cozyhome.inventory.repository.ProductColorRepository;
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
			System.out.println("GETTING QUANTITY");
			quantity = inventory.get().getQuantity();
			log.info("GET QUANTITY [" + quantity + "] for product skuCode [" + request.getProductSkuCode()
					+ "] and color hex [" + request.getColorHex() + "].");
		}
		return quantity;
	}

	@Override
	public List<ProductQuantityStatusDto> getQuantityStatusBySkuCodeList(ProductSkuCodeRequest request) {
		List<Inventory> inventoryList = inventoryRepository
				.findByProductColorProductSkuCodeIn(request.getProductSkuCodeList());
		Map<String, List<Inventory>> map = groupInventoryBySkuCode(inventoryList);		
		return map.entrySet().stream().map(entry -> mapToDto(entry.getKey(), entry.getValue())).toList();
	}
	
	private Map<String, List<Inventory>> groupInventoryBySkuCode(List<Inventory> inventoryList){
		Map<String, List<Inventory>> map = new HashMap<>();
		for(Inventory inventory : inventoryList) {
			String productSkuCode = inventory.getProductColor().getProductSkuCode();
			map.computeIfAbsent(productSkuCode, k -> new ArrayList<>()).add(inventory);
		}
		return map;
	}
	
	private ProductQuantityStatusDto mapToDto(String productSkuCode, List<Inventory> inventoryList) {
		int totalQuntity = inventoryList.stream().mapToInt(Inventory::getQuantity).sum();
		ProductQuantityStatusDto dto = new ProductQuantityStatusDto();
		dto.setProductSkuCode(productSkuCode);
		dto.setQuantityStatus(ProductQuantityStatus.getByProductQuantity(totalQuntity).getDescription());
		return dto;
	}

	@Override
	public List<ColorQuantityStatusDto> getQuantityStatusBySkuCode(String productSkuCode) {
		List<Inventory> inventoryList = inventoryRepository.findByProductColorProductSkuCode(productSkuCode);
		return inventoryList.stream().map(this::map).toList();
	}
	
	private ColorQuantityStatusDto map(Inventory inventory) {
		ColorQuantityStatusDto dto = new ColorQuantityStatusDto();
		dto.setColorHex(inventory.getProductColor().getColorHex());
		dto.setQuantityStatus(ProductQuantityStatus.getByProductQuantity(inventory.getQuantity()).getDescription());
		return dto;
	}
}
