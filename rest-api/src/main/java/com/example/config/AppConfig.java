package com.example.config;

import com.example.application.api.ProductServiceApi;
import com.example.application.api.productcreation.ProductCreationInput;
import com.example.application.api.productcreation.ProductCreationOuput;
import com.example.application.api.productrenaming.ProductRenameInput;
import com.example.application.api.productrenaming.ProductRenameOutput;
import com.example.application.gateways.ProductRepository;
import com.example.application.internal.ProductService;
import com.example.domain.factories.ProductFactory;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Clock;

@Configuration
@EnableJpaRepositories(enableDefaultTransactions = false, basePackages = "com.example.repositories")
public class AppConfig {
    @Bean
    public ProductServiceApi productServiceApi(ProductRepository repository, final ProductFactory productFactory) {
        return new ProductService(repository, productFactory) {
            @Transactional
            @Override
            public ProductCreationOuput createProduct(ProductCreationInput productInput) {
                return super.createProduct(productInput);
            }

            @Transactional
            @Override
            public ProductRenameOutput renameProduct(ProductRenameInput productRenameInput) {
                return super.renameProduct(productRenameInput);
            }
        };
    }

    @Bean
    public ProductFactory productFactory() {
        return new ProductFactory(Clock.systemUTC());
    }
}
