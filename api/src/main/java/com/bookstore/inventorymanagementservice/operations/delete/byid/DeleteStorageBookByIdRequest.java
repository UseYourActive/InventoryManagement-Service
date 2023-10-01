package com.bookstore.inventorymanagementservice.operations.delete.byid;

import com.bookstore.inventorymanagementservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Schema(
        description = "Book Request DTO for deleting a storage book by id."
)
@Getter
@Builder
@AllArgsConstructor
public class DeleteStorageBookByIdRequest implements OperationInput {
    @Schema(
            description = "Storage book id."
    )
    private String storageBookId;
}
