package com.inditex.zarachallenge.controller;

import com.inditex.zarachallenge.application.SimilarProductsService;
import com.inditex.zarachallenge.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/similar")
public class SimilarController {

    private final SimilarProductsService similarProductsService;

    @Autowired
    public SimilarController(SimilarProductsService similarProductsService) {
        this.similarProductsService = similarProductsService;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Product>> getSimilarProducts(@PathVariable Long productId) {
        List<Product> similarProducts = similarProductsService.getSimilarProducts(productId);

        if (!similarProducts.isEmpty()) {
            return ResponseEntity.ok(similarProducts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
