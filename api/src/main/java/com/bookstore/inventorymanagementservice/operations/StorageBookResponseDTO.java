package com.bookstore.inventorymanagementservice.operations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Storage Book Response DTO."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class StorageBookResponseDTO {
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
}
