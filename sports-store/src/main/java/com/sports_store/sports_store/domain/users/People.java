package com.sports_store.sports_store.domain.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_users")
@Data
public class People {

    private final static String MESSAGE = "Esse campo é obrigatorio";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message =  MESSAGE)
    @NotEmpty(message = MESSAGE)
    @NotBlank(message = MESSAGE)
    private String name;

    @CPF
    private String cpf;

    @Email
    private String email;

    @NotNull(message =  MESSAGE)
    @NotEmpty(message = MESSAGE)
    @NotBlank(message = MESSAGE)
    private String password;

    @NotNull(message =  MESSAGE)
    @NotEmpty(message = MESSAGE)
    @NotBlank(message = MESSAGE)
    private String address;

    @NotNull(message =  MESSAGE)
    @NotEmpty(message = MESSAGE)
    @NotBlank(message = MESSAGE)
    private String cep;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime create_user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime update_user;

}
