package com.bookstore.inventorymanagementservice.repositories;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StorageBookRepository extends JpaRepository<StorageBook, UUID> {
    Optional<StorageBook> findStorageBookByBookId(UUID id);
}
