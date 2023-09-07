package com.example.controller.product.query;

import com.example.application.api.productquery.ProductFoundOutput;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQueryRestMapper {

    public List<ProductQueryRestResponse> mapToRestResponse(List<ProductFoundOutput> responses) {
        return responses.stream()
                .map(this::toProductQueryRestResponse)
                .toList();
    }

    private ProductQueryRestResponse toProductQueryRestResponse(ProductFoundOutput productFoundOutput) {
        return new ProductQueryRestResponse(
                productFoundOutput.id(),
                productFoundOutput.name(),
                productFoundOutput.description(),
                productFoundOutput.code(),
                productFoundOutput.createdAt());
    }

}
