package com.bookstore.inventorymanagementservice.processors;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.find.byid.FindStorageBookByIdOperation;
import com.bookstore.inventorymanagementservice.operations.find.byid.FindStorageBookByIdRequest;
import com.bookstore.inventorymanagementservice.operations.find.byid.FindStorageBookByIdResponse;
import com.bookstore.inventorymanagementservice.repositories.StorageBookRepository;
import com.bookstore.inventorymanagementservice.utils.RepositoryUtils;
import com.bookstore.inventorymanagementservice.utils.converters.StorageBookToFindStorageBookByIdConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class FindStorageBookByIdOperationProcessor implements FindStorageBookByIdOperation {
    private final StorageBookRepository storageBookRepository;
    private final RepositoryUtils repositoryUtils;
    private final StorageBookToFindStorageBookByIdConverter storageBookToFindStorageBookByIdConverter;

    @Override
    public FindStorageBookByIdResponse process(final FindStorageBookByIdRequest request) {
        String storageBookId = request.getStorageBookId();
        log.info("Processing request to find StorageBook by ID: {}", storageBookId);

        StorageBook storageBook = repositoryUtils.findByStorageBookIdOrThrow(storageBookRepository, UUID.fromString(storageBookId), StorageBook.class.getName());
        log.debug("Found StorageBook by ID: {}", storageBookId);

        FindStorageBookByIdResponse response = storageBookToFindStorageBookByIdConverter.convert(storageBook);
        log.info("Find StorageBook by ID operation completed successfully for ID: {}", storageBookId);

        return response;
    }
}
