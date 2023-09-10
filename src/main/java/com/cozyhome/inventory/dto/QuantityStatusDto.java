package com.cozyhome.inventory.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuantityStatusDto {

	private String status;
	private Map<String, String> colorQuantityStatus;
}
