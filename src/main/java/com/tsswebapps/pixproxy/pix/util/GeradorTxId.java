package com.tsswebapps.pixproxy.pix.util;

import java.util.UUID;

/**
 * Nome: GeradorTxId <br><br>
 * <b>Objetivo(s):</b>  <br>
 * Fornecer um n�mero v�lido para ser usado no TxId. <br><br>
 * Existem dois construtores onde fica claro para quem for usar a classe que <br>
 * deve escolher entre criar um txid com separador ou n�o.
 *
 * <br><br>
 * <b>Exemplo de uso.</b> <br>
 * String semSeparador = GeradorTxId.semSeparador();<br>
 * String comSeparador = GeradorTxId.comSeparador();<br>
 * <br>
 * @param
 * semSeparador - por padr�o � igual a (true)
 * @param
 * SEPARADOR - Uma constante com o valor do Separador padr�o de um UUID.
 * podendo no futuro ser flexibilizado para atender regras do PIX.
 *
 * @Implementador Thiago Sant Anna da Silva <br>
 * @Especificador Thiago Sant Anna da Silva <br>
 * @author Thiago Sant Anna da Silva <br>
 * @version 1.0 <br>
 *
 */

public class GeradorTxId {
    private boolean semSeparador = true;
    private final String SEPARADOR = "-";

    private GeradorTxId() {}

    public static String comSeparador() {
        GeradorTxId geradorTxId = new GeradorTxId();
        geradorTxId.semSeparador = false;
        return geradorTxId.gerar();
    }

    public static String semSeparador() {
        GeradorTxId geradorTxId = new GeradorTxId();
        return geradorTxId.gerar();
    }

    private String gerar() {
        String uuidEmString = UUID.randomUUID().toString();

        if (this.semSeparador) {
            uuidEmString = limparSeparador(uuidEmString);
        }

        return uuidEmString;
    }

    private String limparSeparador(String uuidEmString) {
        return uuidEmString.replace(this.SEPARADOR, "");
    }

}

