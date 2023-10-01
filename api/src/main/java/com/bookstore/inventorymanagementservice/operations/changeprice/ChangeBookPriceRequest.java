package com.bookstore.inventorymanagementservice.operations.changeprice;

import com.bookstore.inventorymanagementservice.annotations.ValidBigDecimalString;
import com.bookstore.inventorymanagementservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.UUID;

@Schema(
        description = "Book Request DTO for changing a books price."
)
@Getter
@Builder
@AllArgsConstructor
public final class ChangeBookPriceRequest implements OperationInput {
    @Schema(
            description = "Book id"
    )
    @UUID
    @NotEmpty(message = "Book id should not be null or empty!")
    private final String bookId;

    @Schema(
            description = "Book new price"
    )
    @NotEmpty(message = "New book price should not be null or empty!")
    @ValidBigDecimalString
    private final String newPrice;
}
