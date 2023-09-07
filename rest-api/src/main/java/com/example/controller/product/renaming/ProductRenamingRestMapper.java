package com.example.controller.product.renaming;

import com.example.application.api.productrenaming.ProductRenameInput;
import com.example.application.api.productrenaming.ProductRenameOutput;
import org.springframework.stereotype.Component;

@Component
public class ProductRenamingRestMapper {

    public ProductRenameInput toApplicationInput(ProductRenamingRestRequest productRenamingRestRequest) {
        return new ProductRenameInput(productRenamingRestRequest.getId(), productRenamingRestRequest.getName());
    }

    public ProductRenamingRestResponse mapToRestResponse(ProductRenameOutput response) {
        return new ProductRenamingRestResponse(
                response.id(),
                response.name(),
                response.description(),
                response.code());
    }
}
