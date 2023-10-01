package com.bookstore.inventorymanagementservice.operations.find.all;

import com.bookstore.inventorymanagementservice.base.OperationOutput;
import com.bookstore.inventorymanagementservice.operations.StorageBookResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Schema(
        description = "Book Response DTO for finding all storage books."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class FindAllStorageBooksResponse implements OperationOutput {
    private List<StorageBookResponseDTO> bookResponseDTOList;
}
