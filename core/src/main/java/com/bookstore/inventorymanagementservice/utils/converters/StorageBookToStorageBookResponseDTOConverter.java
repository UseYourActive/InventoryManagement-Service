package com.bookstore.inventorymanagementservice.utils.converters;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.StorageBookResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StorageBookToStorageBookResponseDTOConverter implements Converter<StorageBook, StorageBookResponseDTO> {
    @Override
    public StorageBookResponseDTO convert(StorageBook source) {
        log.debug("Converting StorageBook to StorageBookResponseDTO: {}", source);

        StorageBookResponseDTO response = StorageBookResponseDTO.builder()
                .storageItemId(String.valueOf(source.getId()))
                .targetBookId(String.valueOf(source.getBookId()))
                .price(String.valueOf(source.getPrice()))
                .quantity(String.valueOf(source.getQuantity()))
                .build();
        log.debug("Conversion result: {}", response);

        return response;
    }
}
