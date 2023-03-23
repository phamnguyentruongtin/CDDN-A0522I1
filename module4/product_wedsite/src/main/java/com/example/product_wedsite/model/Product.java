package com.example.product_wedsite.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "codeProduct")
    @NotEmpty(message = "Ma San Pham Bi Rong")
    private String codeProduct;

    @Column(name = "nameProduct")
    @NotEmpty(message = "Ten San Pham Khong Duoc De Rong")
    private String nameProduct;
    @NotEmpty(message = "Nha SX Khong Duoc Rong")
    private String manufacturer;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String date;

    public Product(String codeProduct, String nameProduct, String manufacturer, String date) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.manufacturer = manufacturer;
        this.date = date;
    }

    public Product() {
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
