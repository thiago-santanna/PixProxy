package com.tsswebapps.pixproxy.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_emissor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emissor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true, nullable = false)
    private String cnpjCpf;
    private String email;
    @Column(nullable = false)
    private String clientId;
    @Column(nullable = false)
    private String clientSecret;
}
