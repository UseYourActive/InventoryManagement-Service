package com.bookstore.inventorymanagementservice.operations.find.byids;

import com.bookstore.inventorymanagementservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Schema(
        description = "Book Request DTO for finding all storage books by ids."
)
@Getter
@Builder
@AllArgsConstructor
public final class FindStorageBooksByIdsRequest implements OperationInput {
    @Schema(
            description = "Input ids"
    )
    private List<String> ids;
}
