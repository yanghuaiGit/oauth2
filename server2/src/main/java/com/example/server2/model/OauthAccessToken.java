package com.example.server2.model;

import java.io.Serializable;

public class OauthAccessToken implements Serializable {
    private String authenticationId;

    private String tokenId;

    private String userName;

    private String clientId;

    private String refreshToken;

    private static final long serialVersionUID = 1L;

    public String getAuthenticationId() {
        return authenticationId;
    }

    public OauthAccessToken withAuthenticationId(String authenticationId) {
        this.setAuthenticationId(authenticationId);
        return this;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId == null ? null : authenticationId.trim();
    }

    public String getTokenId() {
        return tokenId;
    }

    public OauthAccessToken withTokenId(String tokenId) {
        this.setTokenId(tokenId);
        return this;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId == null ? null : tokenId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public OauthAccessToken withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getClientId() {
        return clientId;
    }

    public OauthAccessToken withClientId(String clientId) {
        this.setClientId(clientId);
        return this;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public OauthAccessToken withRefreshToken(String refreshToken) {
        this.setRefreshToken(refreshToken);
        return this;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authenticationId=").append(authenticationId);
        sb.append(", tokenId=").append(tokenId);
        sb.append(", userName=").append(userName);
        sb.append(", clientId=").append(clientId);
        sb.append(", refreshToken=").append(refreshToken);
        sb.append("]");
        return sb.toString();
    }
}