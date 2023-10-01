package com.bookstore.inventorymanagementservice.operations.export;

import com.bookstore.inventorymanagementservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.UUID;

@Schema(
        description = "Book Request DTO for exporting books / a book."
)
@Getter
@Builder
@AllArgsConstructor
public final class ExportBookRequest implements OperationInput {
    @Schema(
            description = "Book id"
    )
    @UUID
    @NotEmpty(message = "Book id should not be null or empty!")
    public final String bookId;

    @Schema(
            description = "Book quantity to export"
    )
    @NotEmpty(message = "Quantity to export should not be null or empty!")
    public final String quantityToExport;
}
