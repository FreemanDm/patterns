package com.freeman.patterns.adapter.shop2;

import java.util.List;

public class PriceCalculator {
    public double calcTotal(List<Pricable> pricables){
        return pricables.stream().mapToDouble(Pricable::getPrice).sum();
    }
}
