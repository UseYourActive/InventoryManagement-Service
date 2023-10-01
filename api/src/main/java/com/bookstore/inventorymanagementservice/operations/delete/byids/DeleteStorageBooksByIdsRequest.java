package com.bookstore.inventorymanagementservice.operations.delete.byids;

import com.bookstore.inventorymanagementservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Schema(
        description = "Book Request DTO for deleting storage books by ids."
)
@Getter
@Builder
@AllArgsConstructor
public class DeleteStorageBooksByIdsRequest implements OperationInput {
    private List<String> ids;
}
