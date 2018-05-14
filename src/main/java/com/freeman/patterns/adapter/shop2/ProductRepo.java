package com.freeman.patterns.adapter.shop2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
//    Costable getProductCostable();
    List<Product> findAll();
}
