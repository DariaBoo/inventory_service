package com.cozyhome.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ColorQuantityStatusDto {

	private String colorHex;
	private String quantityStatus;
}
