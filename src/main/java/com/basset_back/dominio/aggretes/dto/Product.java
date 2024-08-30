package com.basset_back.dominio.aggretes.dto;

import com.basset_back.infraestructure.entity.Categoria;
import com.basset_back.infraestructure.entity.ItemsCarrito;
import com.basset_back.infraestructure.entity.ItemsOrden;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Product {

    private  Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private long categoryId;
    private String imgUrl;
    private Timestamp dateCreation;
    //private List<ItemsOrden> itemsOrdens;
    //private List<ItemsCarrito> itemsCarritos;
    private Category category;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
