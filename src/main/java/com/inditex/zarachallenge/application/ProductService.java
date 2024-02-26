package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.domain.model.Product;

public interface ProductService {
    Product getProductById(Long productId);
}