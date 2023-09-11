package com.cozyhome.inventory.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class ProductColorDto {

	private String productSkuCode;
	private String colorHex;

	@Override
	@JsonValue
	public String toString() {
		return "ProductColorDto{" +
				"productSkuCode='" + productSkuCode + '\'' +
				", colorHex='" + colorHex + '\'' +
				'}';
	}
}
