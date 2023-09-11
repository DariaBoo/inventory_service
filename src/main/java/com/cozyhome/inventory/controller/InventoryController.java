package com.cozyhome.inventory.controller;

import java.util.List;
import java.util.Map;

import com.cozyhome.inventory.dto.CheckingProductAvailableAndStatusDto;
import com.cozyhome.inventory.dto.ProductColorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cozyhome.inventory.dto.QuantityStatusDto;
import com.cozyhome.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
@RestController
public class InventoryController {
	private final InventoryService inventoryService;
	
	//no method - change to shopping cart 
//	@RequestMapping(method = RequestMethod.POST, value = "/default_color_quantity_status/product_color")
//	public ResponseEntity<QuantityStatusDto> getDefaultColorQuantityStatus(@RequestBody ProductColorDto productColorDto){
//		String status = inventoryService.getQuantityStatusByProductColor(productColorDto);	
//		QuantityStatusDto response = new QuantityStatusDto(status);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
	
	//for product card
	@GetMapping("/color_quantity_status/product_skuCode")
	public ResponseEntity<QuantityStatusDto> getColorQuantityStatusBySkuCode(@RequestParam String productSkuCode){
		return ResponseEntity.ok(inventoryService.getProductCardColorQuantityStatus(productSkuCode));
	}	
	
	//for preview
	@PostMapping("/quantity_status_map/product_skuCode_list")
	public ResponseEntity<Map<String, String>> getProductQuantityStatusMap(@RequestBody List<String> productSkuCodeList){
		return ResponseEntity.ok(inventoryService.getQuantityStatusBySkuCodeList(productSkuCodeList));
	}

	// for shopping card
	@PostMapping("/shopping-card-info")
	public ResponseEntity<Map<ProductColorDto, CheckingProductAvailableAndStatusDto>> getProductAvailableStatus(@RequestBody List<ProductColorDto> productColorDto) {
		return ResponseEntity.ok(inventoryService.getProductAvailableStatus(productColorDto));
	}
}
