package com.cozyhome.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InventoryForBasketDto {
    private ProductColorDto productColorDto;
    private CheckingProductAvailableAndStatusDto checkingProductAvailableAndStatusDto;
}
