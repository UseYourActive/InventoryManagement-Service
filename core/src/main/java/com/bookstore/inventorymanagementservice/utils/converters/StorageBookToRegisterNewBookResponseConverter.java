package com.bookstore.inventorymanagementservice.utils.converters;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.register.RegisterNewBookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("StorageBookToRegisterNewBookResponseConverter")
public class StorageBookToRegisterNewBookResponseConverter implements Converter<StorageBook, RegisterNewBookResponse> {
    @Override
    public RegisterNewBookResponse convert(StorageBook source) {
        log.debug("Converting StorageBook to RegisterNewBookResponse: {}", source);

        RegisterNewBookResponse response = RegisterNewBookResponse.builder()
                .storageItemId(String.valueOf(source.getId()))
                .targetBookId(String.valueOf(source.getBookId()))
                .price(String.valueOf(source.getPrice()))
                .quantity(String.valueOf(source.getQuantity()))
                .build();
        log.debug("Conversion result: {}", response);

        return response;
    }
}
