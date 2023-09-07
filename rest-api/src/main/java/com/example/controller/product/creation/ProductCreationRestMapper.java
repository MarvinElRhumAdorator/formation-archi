package com.example.controller.product.creation;


import com.example.application.api.productcreation.ProductCreationInput;
import com.example.application.api.productcreation.ProductCreationOuput;
import org.springframework.stereotype.Component;

@Component
public class ProductCreationRestMapper {

    public ProductCreationInput toApplicationInput(ProductCreationRestRequest productCreationRestRequest) {
        return new ProductCreationInput(
                productCreationRestRequest.getName(),
                productCreationRestRequest.getDescription(),
                productCreationRestRequest.getCode());
    }

    public ProductCreationRestResponse mapToRestResponse(ProductCreationOuput response) {
        return new ProductCreationRestResponse(
                response.id(),
                response.name(),
                response.description(),
                response.code(),
                response.createdAt());
    }
}
