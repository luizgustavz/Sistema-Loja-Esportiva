package com.sports_store.sports_store.domain.entities.product;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.sports_store.sports_store.domain.validationMessage.BrandMessage;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_brand")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = BrandMessage.REQUIRED_NAME)
    private String name;

    @NotBlank(message = BrandMessage.REQUIRED_DESCRIPTION)
    private String description;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_brand")
    private LocalDateTime createAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @Column(name = "update_brand")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "brand", targetEntity = Product.class, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

    public Brand(){}

    public Brand(String name){
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(BrandMessage.REQUIRED_NAME);
        }
        this.name = name.trim();
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setList_product(Set<Product> aProducts) {
        this.products = aProducts;
    }
}
