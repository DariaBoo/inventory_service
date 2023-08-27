package com.cozyhome.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductQuantityStatusDto {
	private String productSkuCode;
	private String quantityStatus;
}
