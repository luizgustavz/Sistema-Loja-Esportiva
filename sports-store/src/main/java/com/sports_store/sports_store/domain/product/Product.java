package com.sports_store.sports_store.domain.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_product")
@Data
public class Product {

    private final static String MEESSAGE = "Esse campo é obrigatorio";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = MEESSAGE)
    @NotBlank(message = MEESSAGE)
    @NotNull(message = MEESSAGE)
    private String name;

    @NotEmpty(message = MEESSAGE)
    @NotBlank(message = MEESSAGE)
    @NotNull(message = MEESSAGE)
    private String short_description;

    @NotEmpty(message = MEESSAGE)
    @NotBlank(message = MEESSAGE)
    @NotNull(message = MEESSAGE)
    private String long_description;

    private Double value_cust;
    private Double value_sell;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime create_product;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDateTime update_product;

    @ManyToOne(targetEntity = Brand.class)
    @JoinColumn(name = "id_brand_product")
    @JsonBackReference(value = "brand_ref")
    private Brand brand;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "id_category_product")
    @JsonBackReference(value = "category_ref")
    private Category category;

}
