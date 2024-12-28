package com.hotwax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
