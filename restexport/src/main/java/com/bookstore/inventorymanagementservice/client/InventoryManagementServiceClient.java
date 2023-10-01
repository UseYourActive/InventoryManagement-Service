package com.bookstore.inventorymanagementservice.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;

@Headers({
        "Content-Type: application/json"
})
@FeignClient(url = "http://localhost:8086", value = "InventoryManagement-Service")
public interface InventoryManagementServiceClient {
}
