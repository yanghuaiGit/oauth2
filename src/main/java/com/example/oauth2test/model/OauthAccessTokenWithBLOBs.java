package com.example.oauth2test.model;

import java.io.Serializable;

public class OauthAccessTokenWithBLOBs extends OauthAccessToken implements Serializable {
    private byte[] token;

    private byte[] authentication;

    private static final long serialVersionUID = 1L;

    public byte[] getToken() {
        return token;
    }

    public OauthAccessTokenWithBLOBs withToken(byte[] token) {
        this.setToken(token);
        return this;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public OauthAccessTokenWithBLOBs withAuthentication(byte[] authentication) {
        this.setAuthentication(authentication);
        return this;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", token=").append(token);
        sb.append(", authentication=").append(authentication);
        sb.append("]");
        return sb.toString();
    }
}