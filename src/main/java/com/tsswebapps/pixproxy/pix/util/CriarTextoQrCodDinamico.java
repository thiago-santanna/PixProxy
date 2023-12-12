package com.tsswebapps.pixproxy.pix.util;

/**
 * Nome: CriarTextoQrCodDinamico <br><br>
 * <b>Objetivo(s):</b>  <br>
 * Gerar um texto para ser usado no copia e cola ou como imagem QRCODE. <br><br>
 *
 * <b>Propriedades</b><br><br>
 *
 *<b>id00Pos02</b>
 * Indica o formato que o Payload do QRCode representa.<br>
 * O campo � fixo, com 02 posi��es e o valor sempre � 01
 * <br><br>
 *
 *<b>id01Pos02</b>
 * Indica o tipo do QRCODE (ponto de inicia��o) como din�mico.<br>
 * O campo � fixo , com 2 posi��es e o valor sempre com 12
 *<br><br>
 *
 *<b>id26pos85</b>
 * � um campo de grupo, englobando 2 outros campos. <br>
 * (ID 00 e ID25) O tamanho desta ID, em homologa��o � 87 e em Produ��o � 85
 *<br><br>
 *
 * um campo para indicar a URL do Banco Central para o pix. <br>
 * � um campo de conte�do fixo, o valor sempre � 14
 *<b>id00Pos14</b>
 * um campo para indicar a URL do Banco Central para o pix. <br>
 * � um campo de conte�do fixo, o valor sempre � 14
 *<br><br>
 *
 *<b>id25Pos63</b>
 * Este campo, indica a URL que o APP pagador l� <br>
 * para obter os dados do Payload e apresentar na tela do usu�rio <br>
 * (� a location gerada na API).<br>
 * Este campo, em homologa��o � 65 posi��es e em Produ��o, s�o 63 posi��es.
 *<br><br>
 *
 *<b>id52Pos04</b>
 * � um campo para indicar a categoria do Payload.<br>
 * O campo � fixo , com 4 posi��es e o valor sempre 0000
 *<br><br>
 *
 *<b>id53Pos03</b>
 * � um campo para indicar o tipo de moeda.<br>
 * O campo � fixo , com 3 posi��es e o valor sempre 986
 *<br><br>
 *
 *<b>id54Pos04</b>
 * � um campo para indicar o valor do QRCode.<br>
 * O campo � vari�vel, sempre com o n�mero de posi��es variando <br>
 * conforme o valor do pagamento e o valor do QRCode com 2 casas decimais <br>
 * (PS: Esse campo � opcional, pois mesmo se o cliente n�o colocar esse campo, <br>
 * o valor ser� mostrado, pois j� foi informado na location)<br>
 * Ex: caso seja 10 reais, ser� 05 posi��es, e o valor 10.00 e assim sucessivamente.
 *<br><br>
 *
 *<b>id58Pos02</b>
 * � um campo para indicar o pa�s de gera��o do QRCode O campo � fixo ,<br>
 * com 2 posi��es e o valor sempre BR (PS: o BR deve ser sempre em LETRAS MAIUSCULAS).
 *<br><br>
 *
 *<b>id59Pos05</b>
 * � um campo para indicar o recebedor do pagamento (Nome da empresa)<br>
 * O campo � fixo , de at� 25 caracteres (Exemplo, SANTANDER s�o 9 caracteres), <br>
 * logo o campo posi��o ser� 09, e o valor SANTANDER. <br>
 * (PS: este campo tem que ser em LETRAS MAIUSCULAS).
 *<br><br>
 *
 *<b>id60Pos09</b>
 * � um campo para indicar a cidade que ocorre a transa��o <br>
 * O campo � fixo , de at� 15 caracteres <br>
 * (Exemplo, SAO PAULO s�o 9 caracteres com o espa�o em branco), <br>
 * logo o campo posi��o ser� 09, e o valor SAO PAULO <br>
 * (PS: Espa�o conta como posi��o e sempre em LETRA MAIUSCULA)
 *<br><br>
 *
 *<b>id62Pos07</b>
 * � um campo de grupo, englobando 1 outro campo. (ID 05) O tamanho desta ID � 07
 *<br><br>
 *
 *<b>id05Pos03</b>
 * � um campo para indicar o TXID, como j� informado na location, <br>
 * n�o precisa ser preenchido novamente, neste caso, preencher com 3 posi��es, e o valor ***
 *<br><br>
 *
 *<b>id63Pos04</b>
 * � um campo para indicar o CRC16 para controle dos dados indicados. <br>
 * Ele � calculado com base em todos os caracteres anteriores, incluindo o campo 6304. <br>
 * A varia��o de qualquer dado interfere neste campo.<br>
 * Para auxilio, pe�o que utilizem os sites pix.nascent.com.br e o lammertibies.nl para auxilio no c�lculo.<br>
 * O tamanho desta ID sempre � 4.<br>
 * Ex: ID: 63 Posi��es: 04 Valor: 78B1
 *<br><br>
 *
 * @param
 *
 *
 * @Implementador Thiago Sant Anna da Silva <br>
 * @Especificador Thiago Sant Anna da Silva <br>
 * @author Thiago Sant Anna da Silva <br>
 * @version 1.0 <br>
 *
 */

public class CriarTextoQrCodDinamico {
    private final static String ID_FORMATO_PAYLOAD = "00";
    private final static String ID_TIPO_QRCODE = "01";
    private final static String ID_GRUPO_INFORMACAO_CONTA = "26";
    private final static String ID_GRUPO_INFORMACAO_CONTA_URL_BANCO_CENTRAL_PIX = "00";
    private final static String ID_GRUPO_INFORMACAO_URL_DADOS_PAYLOAD = "25";
    private final static String ID_CATEGORIA_PAYLOAD = "52";
    private final static String ID_TIPO_MOEDA = "53";
    private final static String ID_VALOR_PIX = "54";
    private final static String ID_PAIS_PIX = "58";
    private final static String ID_NOME_RECEBEDOR = "59";
    private final static String ID_CIDADE_PIX = "60";
    private final static String ID_GRUPO_INFORMACAO_ADICIONAL = "62";
    private final static String ID_TXID = "05";
    private final static String ID_CRC16 = "63";

    private String titularConta;
    private String cidadeTitularConta;
    private final String TXID = "***";
    private String valorTransacao;
    private String urlPayLoad;

    private CriarTextoQrCodDinamico() {}
    public static CriarTextoQrCodDinamico create() {
        return new CriarTextoQrCodDinamico();
    }

    public String getPayloadPIX() {
        String payloadPIX = this.getValue(ID_FORMATO_PAYLOAD, "01");
        payloadPIX += this.getValue(ID_TIPO_QRCODE, "12");
        payloadPIX += this.getInformacaoConta();
        payloadPIX += this.getValue(ID_CATEGORIA_PAYLOAD, "0000");
        payloadPIX += this.getValue(ID_TIPO_MOEDA, "986");
        payloadPIX += this.getValue(ID_VALOR_PIX, this.valorTransacao);
        payloadPIX += this.getValue(ID_PAIS_PIX, "BR");
        payloadPIX += this.getValue(ID_NOME_RECEBEDOR, this.titularConta);
        payloadPIX += this.getValue(ID_CIDADE_PIX, this.cidadeTitularConta);
        payloadPIX += this.getDadosAdicionais();
        return payloadPIX + this.getCRC16(payloadPIX);
    }

    private String getCRC16(String payload) {
        payload += ID_CRC16 + "04";
        int crcStr = CalculaCRC16.calculateStr(payload);
        return ID_CRC16 + "04"+String.format("%04X%n", crcStr);
    }

    private String getInformacaoConta() {
        String urlBancoCentral = this.getValue(ID_GRUPO_INFORMACAO_CONTA_URL_BANCO_CENTRAL_PIX, "br.gov.bcb.pix");

        String urlPayLoad = "";
        if (this.urlPayLoad != null && !this.urlPayLoad.isEmpty()) {
            urlPayLoad = this.getValue(ID_GRUPO_INFORMACAO_URL_DADOS_PAYLOAD, this.urlPayLoad);
        }
        return this.getValue(ID_GRUPO_INFORMACAO_CONTA, urlBancoCentral + urlPayLoad);
    }

    private String getDadosAdicionais() {
        String implementacaoTxId = this.getValue(ID_TXID, this.TXID);
        return this.getValue(ID_GRUPO_INFORMACAO_ADICIONAL, implementacaoTxId);
    }

    private String getValue(String id, String valor) {
        String tamanho = String.format("%02d", valor.length());
        return id + tamanho + valor;
    }
    public CriarTextoQrCodDinamico setTitularConta(String titularConta) {
        this.titularConta = titularConta;
        return this;
    }
    public CriarTextoQrCodDinamico setCidadeTitularConta(String cidadeTitularConta) {
        this.cidadeTitularConta = cidadeTitularConta;
        return this;
    }
    public CriarTextoQrCodDinamico setValorTransacao(String valorTransacao) {
        this.valorTransacao = valorTransacao;
        return this;
    }
    public CriarTextoQrCodDinamico setUrlPayLoad(String urlPayLoad) {
        this.urlPayLoad = urlPayLoad;
        return this;
    }


}


