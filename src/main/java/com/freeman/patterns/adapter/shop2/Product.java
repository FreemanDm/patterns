package com.freeman.patterns.adapter.shop2;


//import com.freeman.patterns.adapter.shop2.service.Currencies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "productCostable")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Costable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double cost;
    private String currency = "ILS";

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return "Product: " +
                "name=" + name +
                ", cost=" + cost +
                ", currency=ILS" /*+ currency*/;
    }
}
