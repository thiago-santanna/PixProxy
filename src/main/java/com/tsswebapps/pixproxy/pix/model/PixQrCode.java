package com.tsswebapps.pixproxy.pix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PixQrCode {
    private String status;
    private Calendario calendario;
    private String location;
    private String txid;
    private String revisao;
    private Devedor devedor;
    private Valor valor;
    private String chave;
    private String solicitacaoPagador;
    private List<InformacaoAdicional> infoAdicionais = new ArrayList<>();
    private String pixCopiaECola;
}
