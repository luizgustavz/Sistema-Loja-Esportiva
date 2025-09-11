package com.sports_store.sports_store.domain.state;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_state")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class State {

    private final static String MESSAGE = "Esse campo é obrigátario.";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @NotBlank(message = MESSAGE)
    @NotEmpty(message = MESSAGE)
    @EqualsAndHashCode.Include
    private String name;

    @NotNull
    @Size(max = 2)
    @NotBlank(message = MESSAGE)
    @NotEmpty(message = MESSAGE)
    private String acronym;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime create_state;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDateTime update_state;

}
