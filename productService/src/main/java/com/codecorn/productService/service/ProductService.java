package com.codecorn.productService.service;

import com.codecorn.productService.model.ProductRequest;
import com.codecorn.productService.model.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

}
