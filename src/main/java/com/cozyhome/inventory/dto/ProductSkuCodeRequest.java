package com.cozyhome.inventory.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSkuCodeRequest {

	private List<String> productSkuCodeList;
}
