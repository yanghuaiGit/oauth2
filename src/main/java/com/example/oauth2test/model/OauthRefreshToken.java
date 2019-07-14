package com.example.oauth2test.model;

import java.io.Serializable;

public class OauthRefreshToken implements Serializable {
    private String tokenId;

    private byte[] token;

    private byte[] authentication;

    private static final long serialVersionUID = 1L;

    public String getTokenId() {
        return tokenId;
    }

    public OauthRefreshToken withTokenId(String tokenId) {
        this.setTokenId(tokenId);
        return this;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId == null ? null : tokenId.trim();
    }

    public byte[] getToken() {
        return token;
    }

    public OauthRefreshToken withToken(byte[] token) {
        this.setToken(token);
        return this;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public OauthRefreshToken withAuthentication(byte[] authentication) {
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
        sb.append(", tokenId=").append(tokenId);
        sb.append(", token=").append(token);
        sb.append(", authentication=").append(authentication);
        sb.append("]");
        return sb.toString();
    }
}