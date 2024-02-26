package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.domain.model.Product;

import java.util.List;

public interface SimilarProductsService {
    List<Product> getSimilarProducts(Long productId);
}
