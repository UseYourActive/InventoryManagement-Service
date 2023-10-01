package com.bookstore.inventorymanagementservice.processors;

import com.bookstore.inventorymanagementservice.entities.StorageBook;
import com.bookstore.inventorymanagementservice.operations.StorageBookResponseDTO;
import com.bookstore.inventorymanagementservice.operations.find.all.FindAllStorageBooksOperation;
import com.bookstore.inventorymanagementservice.operations.find.all.FindAllStorageBooksRequest;
import com.bookstore.inventorymanagementservice.operations.find.all.FindAllStorageBooksResponse;
import com.bookstore.inventorymanagementservice.repositories.StorageBookRepository;
import com.bookstore.inventorymanagementservice.utils.converters.StorageBookToStorageBookResponseDTOConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class FindAllStorageBooksOperationProcessor implements FindAllStorageBooksOperation {
    private final StorageBookRepository storageBookRepository;
    private final StorageBookToStorageBookResponseDTOConverter storageBookToStorageBookResponseDTOConverter;

    @Override
    public FindAllStorageBooksResponse process(final FindAllStorageBooksRequest request) {
        log.info("Processing request to find all storage books");

        Integer pageNumber = request.getPageNumber();
        Integer numberOfBooksPerPage = request.getNumberOfBooksPerPage();

        PageRequest pageRequest = PageRequest.of(pageNumber, numberOfBooksPerPage);

        Page<StorageBook> allStorageBooks = storageBookRepository.findAll(pageRequest);
        log.debug("Found {} storage books", allStorageBooks.getTotalElements());

        List<StorageBookResponseDTO> storageBookResponseDTOList = allStorageBooks.stream()
                .map(storageBookToStorageBookResponseDTOConverter::convert)
                .toList();

        FindAllStorageBooksResponse response = FindAllStorageBooksResponse.builder()
                .bookResponseDTOList(storageBookResponseDTOList)
                .build();
        log.info("Found {} storage books in response", storageBookResponseDTOList.size());

        return response;
    }
}
