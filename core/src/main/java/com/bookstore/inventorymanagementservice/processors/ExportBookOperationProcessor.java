package com.bookstore.inventorymanagementservice.processors;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.export.ExportBookOperation;
import com.bookstore.inventorymanagementservice.operations.export.ExportBookRequest;
import com.bookstore.inventorymanagementservice.operations.export.ExportBookResponse;
import com.bookstore.inventorymanagementservice.repositories.StorageBookRepository;
import com.bookstore.inventorymanagementservice.utils.RepositoryUtils;
import com.bookstore.inventorymanagementservice.utils.converters.StorageBookToExportBookResponseConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ExportBookOperationProcessor implements ExportBookOperation {
    private final StorageBookRepository storageBookRepository;
    private final RepositoryUtils repositoryUtils;
    private final StorageBookToExportBookResponseConverter storageBookToExportBookResponseConverter;

    @Override
    public ExportBookResponse process(final ExportBookRequest request) {
        String bookId = request.getBookId();
        String quantityToExport = request.getQuantityToExport();
        log.info("Processing request to export {} units of book with ID: {}", quantityToExport, bookId);

        StorageBook storageBook = repositoryUtils.findByStorageBookIdOrThrow(storageBookRepository, UUID.fromString(bookId), StorageBook.class.getName());

//        StorageBook storageBook = storageBookRepository.findById(UUID.fromString(bookId))
//                .orElseThrow(() -> {
//                    log.error("StorageBook not found for ID: {}", bookId);
//                    return new StorageBookNotFoundException();
//                });

        storageBook.setQuantity(storageBook.getQuantity() - Integer.parseInt(quantityToExport));
        log.info("Updated quantity for book with ID {}: new quantity = {}", bookId, storageBook.getQuantity());

        StorageBook savedBook = storageBookRepository.save(storageBook);
        log.info("Book with ID {} saved successfully", bookId);

        ExportBookResponse response = storageBookToExportBookResponseConverter.convert(savedBook);
        log.info("Export operation completed successfully for book with ID: {}", bookId);

        return response;
    }
}
