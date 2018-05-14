package com.freeman.patterns.adapter.shop2;


//import com.freeman.patterns.adapter.shop2.service.Currencies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "productPricable")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPricable implements Pricable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String currency = "ILS";

    @Override
    public String toString() {
        return "Product: " +
                "name=" + name +
                ", cost=" + price +
                ", currency=ILS" /*+ currency*/;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
