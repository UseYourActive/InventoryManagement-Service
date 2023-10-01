package com.bookstore.inventorymanagementservice.utils;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.repositories.StorageBookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RepositoryUtils {
//    public <T, ID> T findByIdOrThrow(CrudRepository<T, ID> repository, ID id, String entityName) {
//        return repository.findById(id)
//                .orElseThrow(() -> {
//                    log.error("{} not found for ID: {}", entityName, id);
//                    return new EntityNotFoundException(entityName);
//                });
//    }

    public StorageBook findByStorageBookIdOrThrow(StorageBookRepository repository, UUID id, String entityName) {
        return repository.findStorageBookByBookId(id)
                .orElseThrow(() -> {
            log.error("{} not found for ID: {}", entityName, id);
            return new EntityNotFoundException(entityName);
        });
    }
}
