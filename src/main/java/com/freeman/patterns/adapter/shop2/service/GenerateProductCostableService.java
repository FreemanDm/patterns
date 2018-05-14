package com.freeman.patterns.adapter.shop2.service;

import com.freeman.patterns.adapter.shop2.Costable;
import com.freeman.patterns.adapter.shop2.Pricable;
import com.freeman.patterns.adapter.shop2.Product;
import com.freeman.patterns.adapter.shop2.ProductRepo;
import com.freeman.patterns.adapter.shop2.util.Generator;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Data
public class GenerateProductCostableService extends Product {

    @Autowired
    private ProductRepo productRepo;

    private List<Costable> productCostables = new ArrayList<>();

    private float MIN = 1.00f;
    private float MAX = 50000.00f;
    private int MININT = 1;
    private int MAXINT = 1000000000;
    private float price;
    private String name;
    private Product productCostable;

    @SneakyThrows
    public Costable generateProduct() {
        price = Generator.generatePrice(MIN, MAX);
        name = Generator.generateName(MININT, MAXINT);
//        productCostable = Product.builder().name(this.name).cost(this.price).currency(Currencies.ILS).build();
        productCostable = Product.builder().name(this.name).cost(this.price).currency("ILS").build();
        productRepo.save(productCostable);
        System.out.println("Was saved!");
        return productRepo.findOne(productCostable.getId());
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
}
