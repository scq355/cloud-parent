package com.cloud.product.bean;

import java.util.Date;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Date birthdate;

    public Product() {
    }

    public Product(Integer id, String name, Double price, Date birthdate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", birthdate=" + birthdate +
                '}';
    }
}
