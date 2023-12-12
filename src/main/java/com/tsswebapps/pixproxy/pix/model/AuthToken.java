package com.tsswebapps.pixproxy.pix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {
    private String access_token;
    private String token_type;
    private String expires_in;
    private String refresh_token;
    private String scope;
    private String active;
}
