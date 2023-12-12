package com.tsswebapps.pixproxy.pix.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Conversores {
    public String fromInputStreamReader(InputStream inputStream) throws Exception {
        String convertido = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return convertido;
    }

    public String removeDigitosBarras(String codigoGuiaRecebimento2) {
        if(codigoGuiaRecebimento2 != null) {
            String codigoBarras = "";
            String[] partesBarras = codigoGuiaRecebimento2.split(" ", 0);
            if(partesBarras.length > 1) {
                for (String pBarras : partesBarras) {
                    String temp = pBarras.substring(0, 11);
                    codigoBarras += temp;
                }
            }else {
                codigoBarras = partesBarras[0];
            }
            return codigoBarras;
        }
        return "";
    }
}
