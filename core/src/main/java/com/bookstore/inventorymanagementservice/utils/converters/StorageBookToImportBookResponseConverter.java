package com.bookstore.inventorymanagementservice.utils.converters;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.importing.ImportBookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("StorageBookToImportBookResponseConverter")
public class StorageBookToImportBookResponseConverter implements Converter<StorageBook, ImportBookResponse> {
    @Override
    public ImportBookResponse convert(StorageBook source) {
        log.debug("Converting StorageBook to ImportBookResponse: {}", source);

        ImportBookResponse response = ImportBookResponse.builder()
                .storageItemId(String.valueOf(source.getId()))
                .targetBookId(String.valueOf(source.getBookId()))
                .price(String.valueOf(source.getPrice()))
                .quantity(String.valueOf(source.getQuantity()))
                .build();
        log.debug("Conversion result: {}", response);

        return response;
    }
}
