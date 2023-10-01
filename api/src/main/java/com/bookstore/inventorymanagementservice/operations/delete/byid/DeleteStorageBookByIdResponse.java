package com.bookstore.inventorymanagementservice.operations.delete.byid;

import com.bookstore.inventorymanagementservice.base.OperationOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Book Response DTO for deleting a storage book by id."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class DeleteStorageBookByIdResponse implements OperationOutput {
    @Schema(
            description = "Storage item id"
    )
    private String storageItemId;

    @Schema(
            description = "Book id"
    )
    private String targetBookId;

    @Schema(
            description = "Price"
    )
    private String price;

    @Schema(
            description = "Quantity"
    )
    private String quantity;

    @Schema(
            description = "Status"
    )
    private String status;
}
