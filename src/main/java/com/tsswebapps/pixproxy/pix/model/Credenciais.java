package com.tsswebapps.pixproxy.pix.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Credenciais {
    private final String clientId;
    private final String clientSecret;
    private final String textAuthorization;

    public Credenciais(String clientId, String clientSecret) {
        this.clientId = clientId.trim();
        this.clientSecret = clientSecret.trim();
        this.textAuthorization = this.clientId + ":" + this.clientSecret;
    }

    public String authorization() {
        byte[] bs = Base64.getEncoder().encode(
                this.textAuthorization.getBytes(StandardCharsets.ISO_8859_1));
        return new String(bs, StandardCharsets.ISO_8859_1);
    }
}
