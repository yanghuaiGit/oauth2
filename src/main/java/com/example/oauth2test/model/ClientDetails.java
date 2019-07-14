package com.example.oauth2test.model;

import java.io.Serializable;

public class ClientDetails implements Serializable {
    private String appid;

    private String resourceids;

    private String appsecret;

    private String scope;

    private String granttypes;

    private String redirecturl;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalinformation;

    private String autoapprovescopes;

    private static final long serialVersionUID = 1L;

    public String getAppid() {
        return appid;
    }

    public ClientDetails withAppid(String appid) {
        this.setAppid(appid);
        return this;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getResourceids() {
        return resourceids;
    }

    public ClientDetails withResourceids(String resourceids) {
        this.setResourceids(resourceids);
        return this;
    }

    public void setResourceids(String resourceids) {
        this.resourceids = resourceids == null ? null : resourceids.trim();
    }

    public String getAppsecret() {
        return appsecret;
    }

    public ClientDetails withAppsecret(String appsecret) {
        this.setAppsecret(appsecret);
        return this;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }

    public String getScope() {
        return scope;
    }

    public ClientDetails withScope(String scope) {
        this.setScope(scope);
        return this;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getGranttypes() {
        return granttypes;
    }

    public ClientDetails withGranttypes(String granttypes) {
        this.setGranttypes(granttypes);
        return this;
    }

    public void setGranttypes(String granttypes) {
        this.granttypes = granttypes == null ? null : granttypes.trim();
    }

    public String getRedirecturl() {
        return redirecturl;
    }

    public ClientDetails withRedirecturl(String redirecturl) {
        this.setRedirecturl(redirecturl);
        return this;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl == null ? null : redirecturl.trim();
    }

    public String getAuthorities() {
        return authorities;
    }

    public ClientDetails withAuthorities(String authorities) {
        this.setAuthorities(authorities);
        return this;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities == null ? null : authorities.trim();
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public ClientDetails withAccessTokenValidity(Integer accessTokenValidity) {
        this.setAccessTokenValidity(accessTokenValidity);
        return this;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public ClientDetails withRefreshTokenValidity(Integer refreshTokenValidity) {
        this.setRefreshTokenValidity(refreshTokenValidity);
        return this;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalinformation() {
        return additionalinformation;
    }

    public ClientDetails withAdditionalinformation(String additionalinformation) {
        this.setAdditionalinformation(additionalinformation);
        return this;
    }

    public void setAdditionalinformation(String additionalinformation) {
        this.additionalinformation = additionalinformation == null ? null : additionalinformation.trim();
    }

    public String getAutoapprovescopes() {
        return autoapprovescopes;
    }

    public ClientDetails withAutoapprovescopes(String autoapprovescopes) {
        this.setAutoapprovescopes(autoapprovescopes);
        return this;
    }

    public void setAutoapprovescopes(String autoapprovescopes) {
        this.autoapprovescopes = autoapprovescopes == null ? null : autoapprovescopes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appid=").append(appid);
        sb.append(", resourceids=").append(resourceids);
        sb.append(", appsecret=").append(appsecret);
        sb.append(", scope=").append(scope);
        sb.append(", granttypes=").append(granttypes);
        sb.append(", redirecturl=").append(redirecturl);
        sb.append(", authorities=").append(authorities);
        sb.append(", accessTokenValidity=").append(accessTokenValidity);
        sb.append(", refreshTokenValidity=").append(refreshTokenValidity);
        sb.append(", additionalinformation=").append(additionalinformation);
        sb.append(", autoapprovescopes=").append(autoapprovescopes);
        sb.append("]");
        return sb.toString();
    }
}