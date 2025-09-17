package com.sports_store.sports_store.domain.entities.state;
import com.sports_store.sports_store.domain.validationMessage.CityMessage;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_city")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = CityMessage.REQUIRED_NAME)
    private String name;

    @CreationTimestamp
    @Column(name = "create_city")
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_city")
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = State.class)
    @JoinColumn(name = "id_state_city")
    private State state;

    public City(){};

    public City(String name){
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
            throw new IllegalArgumentException(CityMessage.INVALID_NAME);
        }
        this.name = name;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
