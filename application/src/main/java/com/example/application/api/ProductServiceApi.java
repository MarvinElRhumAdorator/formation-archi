package com.example.application.api;

import com.example.application.api.productcreation.ProductCreationInput;
import com.example.application.api.productcreation.ProductCreationOuput;
import com.example.application.api.productquery.ProductFoundOutput;
import com.example.application.api.productrenaming.ProductRenameInput;
import com.example.application.api.productrenaming.ProductRenameOutput;

import java.util.List;

public interface ProductServiceApi {
    ProductCreationOuput createProduct(ProductCreationInput productCreationInput);

    ProductRenameOutput renameProduct(ProductRenameInput productRenameInput);

    List<ProductFoundOutput> findAllProducts();
}
