package com.inditex.zarachallenge.application.impl;

import com.inditex.zarachallenge.application.ProductService;
import com.inditex.zarachallenge.domain.model.Product;
import com.inditex.zarachallenge.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
