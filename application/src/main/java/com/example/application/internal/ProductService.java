package com.example.application.internal;


import com.example.application.DateUtils;
import com.example.application.api.ProductServiceApi;
import com.example.application.api.productcreation.ProductCreationInput;
import com.example.application.api.productcreation.ProductCreationOuput;
import com.example.application.api.productquery.ProductFoundOutput;
import com.example.application.api.productrenaming.ProductRenameInput;
import com.example.application.api.productrenaming.ProductRenameOutput;
import com.example.application.gateways.ProductRepository;
import com.example.domain.exception.AlreadyExistingProductException;
import com.example.domain.exception.NonExistingProductException;
import com.example.domain.factories.ProductFactory;
import com.example.domain.model.Product;

import java.time.Instant;
import java.util.List;

public class ProductService implements ProductServiceApi {
    private final ProductRepository repository;
    private final ProductFactory productFactory;

    public ProductService(ProductRepository repository, ProductFactory productFactory) {
        this.repository = repository;
        this.productFactory = productFactory;
    }

    @Override
    public ProductCreationOuput createProduct(ProductCreationInput productInput) {
        long productCode = productInput.getCode();
        if (repository.existsProductWithCode(productCode)) {
            throw new AlreadyExistingProductException(productCode);
        }

        Product product =  productFactory.create(productInput.getName(), productInput.getDescription(), productCode);

        Product createdProduct = repository.registerNew(product);

        return toProductCreationOuput(createdProduct);
    }

    @Override
    public ProductRenameOutput renameProduct(ProductRenameInput productRenameInput) {


        String productId = productRenameInput.getId();

        Product productToRename = repository.getProduct(productId)
                .orElseThrow(() -> new NonExistingProductException(productId));

        productToRename.setName(productRenameInput.getName());

        repository.updateProduct(productToRename);

        return toProductRenameOutput(productToRename);
    }

    private ProductRenameOutput toProductRenameOutput(Product productToRename) {
        return new ProductRenameOutput(
                productToRename.getId(),
                productToRename.getName(),
                productToRename.getDescription(),
                productToRename.getCode());
    }

    @Override
    public List<ProductFoundOutput> findAllProducts() {
        return repository.getAllProducts().stream().map(ProductService::toProductFoundOutput).toList();
    }

    private static ProductFoundOutput toProductFoundOutput(Product productFound) {
        return new ProductFoundOutput(
                productFound.getId(),
                productFound.getName(),
                productFound.getDescription(),
                productFound.getCode(),
                DateUtils.dateToString(productFound.getCreatedAt()));
    }


    private ProductCreationOuput toProductCreationOuput(Product createdProduct) {
        return new ProductCreationOuput(createdProduct.getId(),
                createdProduct.getName(),
                createdProduct.getDescription(),
                createdProduct.getCode(),
                DateUtils.dateToString(createdProduct.getCreatedAt()));
    }
}
