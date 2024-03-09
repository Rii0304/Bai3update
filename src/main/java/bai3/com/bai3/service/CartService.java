package bai3.com.bai3.service;

import bai3.com.bai3.entity.ProductEntity;

import java.util.Map;

public interface CartService {
    void addToCart(Long productId);

    Map<ProductEntity, Integer> getCart();

    void createOrder();
}
