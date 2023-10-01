package com.bookstore.inventorymanagementservice.processors;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.StorageBookResponseDTO;
import com.bookstore.inventorymanagementservice.operations.find.byids.FindStorageBooksByIdsOperation;
import com.bookstore.inventorymanagementservice.operations.find.byids.FindStorageBooksByIdsRequest;
import com.bookstore.inventorymanagementservice.operations.find.byids.FindStorageBooksByIdsResponse;
import com.bookstore.inventorymanagementservice.repositories.StorageBookRepository;
import com.bookstore.inventorymanagementservice.utils.converters.StorageBookToStorageBookResponseDTOConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class FindStorageBooksByIdsOperationProcessor implements FindStorageBooksByIdsOperation {
    private final StorageBookRepository storageBookRepository;
    private final StorageBookToStorageBookResponseDTOConverter storageBookToStorageBookResponseDTOConverter;

    @Override
    public FindStorageBooksByIdsResponse process(final FindStorageBooksByIdsRequest request) {
        log.info("Processing request to find storage books by IDs");

        List<String> ids = request.getIds();

        List<UUID> uuidList = ids.stream()
                .map(UUID::fromString)
                .toList();

        List<StorageBook> storageBookList = storageBookRepository.findAllById(uuidList);
        log.debug("Found {} storage books by IDs", storageBookList.size());

        List<StorageBookResponseDTO> storageBookResponseDTOList = storageBookList.stream()
                .map(storageBookToStorageBookResponseDTOConverter::convert)
                .toList();

        FindStorageBooksByIdsResponse response = FindStorageBooksByIdsResponse.builder()
                .bookResponseDTOList(storageBookResponseDTOList)
                .build();
        log.info("Found {} storage books by IDs in response", storageBookResponseDTOList.size());

        return response;
    }
}
