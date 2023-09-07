package com.example.controller.product;

import com.example.application.api.ProductServiceApi;
import com.example.application.api.productcreation.ProductCreationInput;
import com.example.application.api.productcreation.ProductCreationOuput;
import com.example.application.api.productrenaming.ProductRenameInput;
import com.example.application.api.productrenaming.ProductRenameOutput;
import com.example.controller.product.creation.ProductCreationRestMapper;
import com.example.controller.product.creation.ProductCreationRestRequest;
import com.example.controller.product.creation.ProductCreationRestResponse;
import com.example.controller.product.query.ProductQueryRestMapper;
import com.example.controller.product.query.ProductQueryRestResponse;
import com.example.controller.product.renaming.ProductRenamingRestMapper;
import com.example.controller.product.renaming.ProductRenamingRestRequest;
import com.example.controller.product.renaming.ProductRenamingRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceApi productServiceApi;

    @Autowired
    private ProductCreationRestMapper creationRestMapper;

    @Autowired
    private ProductRenamingRestMapper renamingRestMapper;

    @Autowired
    private ProductQueryRestMapper queryRestMapper;

    @PostMapping
    public ProductCreationRestResponse create(@RequestBody ProductCreationRestRequest request) {
        ProductCreationInput applicationInput = creationRestMapper.toApplicationInput(request);
        ProductCreationOuput createdProduct = productServiceApi.createProduct(applicationInput);
        return creationRestMapper.mapToRestResponse(createdProduct);
    }

    @PatchMapping
    public ProductRenamingRestResponse rename(@RequestBody ProductRenamingRestRequest request) {
        ProductRenameInput applicationInput = renamingRestMapper.toApplicationInput(request);
        ProductRenameOutput renamedOuput = this.productServiceApi.renameProduct(applicationInput);
        return renamingRestMapper.mapToRestResponse(renamedOuput);
    }

    @GetMapping
    public List<ProductQueryRestResponse> findProducts() {
        return queryRestMapper.mapToRestResponse(productServiceApi.findAllProducts());
    }
}




