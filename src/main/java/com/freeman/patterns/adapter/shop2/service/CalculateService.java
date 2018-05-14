package com.freeman.patterns.adapter.shop2.service;


import com.freeman.patterns.adapter.shop2.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CalculateService extends PriceCalculator { // calculate price of productCostable (from list) and return price in $

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private GenerateProductCostableService generateProductService;

    private ProductAdaptor productAdaptor;
//    private List<Product> productCostables = new ArrayList<>();
    private List<Pricable> productsPricable = new ArrayList<>();
    private List<Costable> productsCostable = new ArrayList<>();

    private ProductPricable productPricable = new ProductPricable();
    private Float totalPrice = 0.0f;

    @Override
    public double calcTotal(List<Pricable> productsPricable) {
        return super.calcTotal(productsPricable);
    }

    public List<Pricable> transformProductToPricable(List<Product> productCostables){
        for (Product productCostable : productCostables) {
//            productAdaptor = new ProductAdaptor(productCostable);
//            productsPricable.(productAdaptor);
            productPricable.setName(productCostable.getName());
            productPricable.setPrice(productCostable.getCost());
            productPricable.setCurrency("ILS");
            productsPricable.add(productPricable);
        }
        return productsPricable;
    }

}
