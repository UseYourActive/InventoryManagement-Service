package com.bookstore.inventorymanagementservice.operations.changeprice;

import com.bookstore.inventorymanagementservice.base.OperationOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Book Response DTO for changing a books price."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class ChangeBookPriceResponse implements OperationOutput {
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
