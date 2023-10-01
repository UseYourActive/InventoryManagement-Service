package com.bookstore.inventorymanagementservice.processors;

import com.bookstore.inventorymanagementservice.utils.converters.StorageBookToRegisterNewBookResponseConverter;
import com.bookstore.inventorymanagementservice.utils.converters.StringToBigDecimalConverter;
import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.register.RegisterNewBookOperation;
import com.bookstore.inventorymanagementservice.operations.register.RegisterNewBookRequest;
import com.bookstore.inventorymanagementservice.operations.register.RegisterNewBookResponse;
import com.bookstore.inventorymanagementservice.repositories.StorageBookRepository;
import com.bookstore.inventorymanagementservice.utils.RepositoryUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class RegisterNewBookOperationProcessor implements RegisterNewBookOperation {
    private final StorageBookRepository storageBookRepository;
    private final StorageBookToRegisterNewBookResponseConverter storageBookToRegisterNewBookResponseConverter;
    private final StringToBigDecimalConverter stringToBigDecimalConverter;
    private final RepositoryUtils repositoryUtils;

    @Override
    public RegisterNewBookResponse process(final RegisterNewBookRequest request) {
        String bookId = request.getBookId();
        String price = request.getPrice();
        log.info("Processing request to register new book with ID: {}", bookId);

        StorageBook storageBook = repositoryUtils.findByStorageBookIdOrThrow(storageBookRepository, UUID.fromString(bookId), StorageBook.class.getName());

//        StorageBook storageBook = storageBookRepository.findStorageBookByBookId(UUID.fromString(bookId))
//                .orElseThrow(() -> {
//                    log.error("StorageBook not found for ID: {}", bookId);
//                    return new StorageBookNotFoundException();
//                });

        BigDecimal newPrice = stringToBigDecimalConverter.convert(price);
        storageBook.setPrice(newPrice);
        log.info("Updated price for book with ID {}: new price = {}", bookId, newPrice);

        StorageBook savedBook = storageBookRepository.save(storageBook);
        log.info("Book with ID {} saved successfully", bookId);

        RegisterNewBookResponse response = storageBookToRegisterNewBookResponseConverter.convert(savedBook);
        log.info("Registration operation completed successfully for book with ID: {}", bookId);

        return response;
    }
}
