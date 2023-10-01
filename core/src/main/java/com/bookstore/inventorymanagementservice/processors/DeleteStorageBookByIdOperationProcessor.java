package com.bookstore.inventorymanagementservice.processors;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.delete.byid.DeleteStorageBookByIdOperation;
import com.bookstore.inventorymanagementservice.operations.delete.byid.DeleteStorageBookByIdRequest;
import com.bookstore.inventorymanagementservice.operations.delete.byid.DeleteStorageBookByIdResponse;
import com.bookstore.inventorymanagementservice.repositories.StorageBookRepository;
import com.bookstore.inventorymanagementservice.utils.RepositoryUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Slf4j
@Service
public class DeleteStorageBookByIdOperationProcessor implements DeleteStorageBookByIdOperation {
    private final StorageBookRepository storageBookRepository;
    private final RepositoryUtils repositoryUtils;

    @Override
    public DeleteStorageBookByIdResponse process(final DeleteStorageBookByIdRequest request) {
        String storageBookId = request.getStorageBookId();

        StorageBook storageBook = repositoryUtils.findByStorageBookIdOrThrow(storageBookRepository, UUID.fromString(storageBookId), StorageBook.class.getName());
        log.info("Deleting storage book with ID: {}", storageBookId);

        storageBookRepository.delete(storageBook);
        log.info("Storage book with ID {} deleted successfully", storageBookId);

        DeleteStorageBookByIdResponse response = DeleteStorageBookByIdResponse.builder()
                .storageItemId(String.valueOf(storageBook.getId()))
                .targetBookId(String.valueOf(storageBook.getBookId()))
                .price(String.valueOf(storageBook.getPrice()))
                .quantity(String.valueOf(storageBook.getQuantity()))
                .status("Deleted")
                .build();
        log.info("Delete operation completed successfully for storage book with ID: {}", storageBookId);

        return response;
    }
}
