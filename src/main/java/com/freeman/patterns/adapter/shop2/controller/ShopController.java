package com.freeman.patterns.adapter.shop2.controller;

import com.freeman.patterns.adapter.shop2.Costable;
import com.freeman.patterns.adapter.shop2.Pricable;
import com.freeman.patterns.adapter.shop2.Product;
import com.freeman.patterns.adapter.shop2.service.CalculateService;
import com.freeman.patterns.adapter.shop2.service.GenerateProductCostableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private GenerateProductCostableService generateProductService;

    @Autowired
    private CalculateService calculateService;


    @RequestMapping("/product")
    public Costable generateProduct(){
        return generateProductService.generateProduct();
    }

    @RequestMapping("/products")
    public List<Product> getAll(){
        return generateProductService.getAllProducts();
    }

    @RequestMapping(value = "/products/convert", method = RequestMethod.POST)
    public List<Pricable> convertToPricable(@RequestBody List<Product> productCostables){

        return calculateService.transformProductToPricable(productCostables);
    }

    @RequestMapping(value = "/products/totalprice", method = RequestMethod.POST)
    public double calculatePrices(@RequestBody List<Pricable> products){

        return calculateService.calcTotal(products);
    }
}
