package com.inditex.zarachallenge.application.impl;

import com.inditex.zarachallenge.application.SimilarProductsService;
import com.inditex.zarachallenge.domain.model.Product;
import com.inditex.zarachallenge.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimilarProductsServiceImpl implements SimilarProductsService {
    private final ProductRepository productRepository;

    @Autowired
    public SimilarProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getSimilarProducts(Long productId) {
        List<Product> similarProductsFromDatabase = productRepository.findSimilarProductIds(productId);

        return similarProductsFromDatabase.stream()
                .map(this::mapToProductDetail)
                .collect(Collectors.toList());
    }

    private Product mapToProductDetail(Product product) {
        return new Product(
                product.getId(),
                product.getName()
        );
    }
}
