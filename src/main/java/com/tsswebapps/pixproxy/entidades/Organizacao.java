package com.tsswebapps.pixproxy.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_organization")
@Data
@Builder
@AllArgsConstructor@NoArgsConstructor
public class Organizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cnpjCpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String numeroEndereco;

    private String complemento;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private LocalDateTime dataValidadeLicenca;

    private Boolean disabled = false;
}
