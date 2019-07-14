package com.example.server2.model;

import java.io.Serializable;

public class OauthCode implements Serializable {
    private String code;

    private byte[] authentication;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public OauthCode withCode(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public OauthCode withAuthentication(byte[] authentication) {
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
        sb.append(", code=").append(code);
        sb.append(", authentication=").append(authentication);
        sb.append("]");
        return sb.toString();
    }
}