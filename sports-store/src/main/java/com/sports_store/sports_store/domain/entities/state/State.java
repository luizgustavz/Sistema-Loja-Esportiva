package com.sports_store.sports_store.domain.entities.state;
import com.sports_store.sports_store.domain.validationMessage.StateMessage;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_state")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = StateMessage.REQUIRED_NAME)
    private String name;

    @NotBlank(message = StateMessage.REQUIRED_ACRONYM)
    private AcronymEnum acronym;

    @NotBlank()
    private Boolean isActive = false;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY, targetEntity = City.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<City> cities = new HashSet<>();

    public State() {};

    public State(String name, AcronymEnum acronym, Boolean isActive){
        setName(name);
        setAcronym(acronym);
        setActive(isActive);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(StateMessage.REQUIRED_NAME);
        }
        this.name = name.trim();
    }

    public AcronymEnum getAcronym() {
        return acronym;
    }

    public void setAcronym(AcronymEnum acronym) {
        if (acronym == null){
            throw new IllegalArgumentException(StateMessage.REQUIRED_ACRONYM);
        }
        this.acronym = acronym;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
