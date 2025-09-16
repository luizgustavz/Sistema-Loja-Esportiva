package com.sports_store.sports_store.domain.entities.product;
import com.sports_store.sports_store.domain.validationMessage.ProductMessage;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

import jakarta.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_product")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = ProductMessage.REQUIRED_NAME)
    private String name;

    @NotBlank(message = ProductMessage.REQUIRED_DESCRIPTION)
    private String shortDescription;

    @NotBlank(message = ProductMessage.REQUIRED_DESCRIPTION)
    private String longDescription;

    @NotBlank(message = ProductMessage.INVALID_ARGUMENT)
    private Double price;

    private Integer stok = 0;

    @CreationTimestamp
    @Column(name = "create_product")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_product")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    @ManyToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_brand_product")
    private Brand brand;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category_product")
    private Category category;

    public Product(){};

    public Product(String name, String shortDescription, String longDescription, Double price, Double sell){
        setName(name);
        setShortDescription(shortDescription);
        setLongDescription(longDescription);
        setPrice(price);
        setStok(stok);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price <= 0){
            throw new IllegalArgumentException(ProductMessage.INVALID_PRICE);
        }
        this.price = price;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        if (!(this.stok > 0)){
            throw new IllegalArgumentException(ProductMessage.INVALID_VALUE_STOCK);
        }
        this.stok = stok;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
