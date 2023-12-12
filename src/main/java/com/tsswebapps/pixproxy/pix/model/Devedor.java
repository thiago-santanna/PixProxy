package com.tsswebapps.pixproxy.pix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Devedor {
    private String nome;
    private String cpf;
    private String cnpj;
}
