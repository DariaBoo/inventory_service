package com.cozyhome.inventory.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cozyhome.inventory.dto.ColorQuantityStatusDto;
import com.cozyhome.inventory.dto.ProductColorDto;
import com.cozyhome.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
@RestController
public class InventoryController {
	private final InventoryService inventoryService;
	
	//for product card
	@RequestMapping(method = RequestMethod.POST, value = "/default_color_quantity_status/product_color", produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> getDefaultColorQuantityStatus(@RequestBody ProductColorDto productColorDto){
		String result = inventoryService.getQuantityStatusByProductColor(productColorDto);	
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//for product card
	@GetMapping("/color_quantity_status_list/product_skuCode")
	public ResponseEntity<List<ColorQuantityStatusDto>> getColorQuantityBySkuCode(@RequestParam String productSkuCode){
		return ResponseEntity.ok(inventoryService.getColorQuantityStatusBySkuCode(productSkuCode));
	}	
	
	//for review
	@PostMapping("/quantity_status_map/product_skuCode_list")
	public ResponseEntity<Map<String, String>> getProductQuantityStatusMap(@RequestBody List<String> productSkuCodeList){
		return ResponseEntity.ok(inventoryService.getQuantityStatusBySkuCodeList(productSkuCodeList));
	}
}
