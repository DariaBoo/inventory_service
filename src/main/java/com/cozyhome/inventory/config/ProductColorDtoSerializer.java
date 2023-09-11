package com.cozyhome.inventory.config;

import com.cozyhome.inventory.dto.ProductColorDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;

public class ProductColorDtoSerializer extends JsonSerializer<ProductColorDto> {

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public void serialize(ProductColorDto productColorDto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, productColorDto);
        jsonGenerator.writeFieldName(writer.toString());
    }
}
