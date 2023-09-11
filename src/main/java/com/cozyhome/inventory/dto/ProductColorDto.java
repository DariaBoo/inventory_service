package com.cozyhome.inventory.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductColorDto {

	@Pattern(regexp = "^\\d{6}$", message = "Invalid SkuCode. SkuCode must be 6 numbers.")
	private String productSkuCode;
	@Pattern(regexp = "^#[A-Za-z0-9]{3,8}+$", message = "Invalid Hex. Hex must start with # and then 3 to 8 characters.")
	private String colorHex;
	
}
