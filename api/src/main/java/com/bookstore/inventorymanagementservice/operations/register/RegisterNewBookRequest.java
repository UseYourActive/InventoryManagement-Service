package com.bookstore.inventorymanagementservice.operations.register;

import com.bookstore.inventorymanagementservice.annotations.ValidBigDecimalString;
import com.bookstore.inventorymanagementservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.UUID;

@Schema(
        description = "Book Request DTO for registering a new book."
)
@Getter
@Builder
@AllArgsConstructor
public final class RegisterNewBookRequest implements OperationInput {
    @Schema(
            description = "Book id"
    )
    @UUID
    @NotEmpty(message = "Book id should not be null or empty!")
    private final String bookId;

    @Schema(
            description = "Book price"
    )
    @NotEmpty(message = "Price should not be null or empty!")
    @ValidBigDecimalString
    private final String price;
}
