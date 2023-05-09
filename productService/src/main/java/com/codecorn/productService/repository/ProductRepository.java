package com.codecorn.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codecorn.productService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
