package com.example.server2.model;

import java.io.Serializable;
import java.util.Date;

public class OauthApprovals implements Serializable {
    private String userid;

    private String clientid;

    private String scope;

    private String status;

    private Date expiresat;

    private Date lastmodifiedat;

    private static final long serialVersionUID = 1L;

    public String getUserid() {
        return userid;
    }

    public OauthApprovals withUserid(String userid) {
        this.setUserid(userid);
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public OauthApprovals withClientid(String clientid) {
        this.setClientid(clientid);
        return this;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public String getScope() {
        return scope;
    }

    public OauthApprovals withScope(String scope) {
        this.setScope(scope);
        return this;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getStatus() {
        return status;
    }

    public OauthApprovals withStatus(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getExpiresat() {
        return expiresat;
    }

    public OauthApprovals withExpiresat(Date expiresat) {
        this.setExpiresat(expiresat);
        return this;
    }

    public void setExpiresat(Date expiresat) {
        this.expiresat = expiresat;
    }

    public Date getLastmodifiedat() {
        return lastmodifiedat;
    }

    public OauthApprovals withLastmodifiedat(Date lastmodifiedat) {
        this.setLastmodifiedat(lastmodifiedat);
        return this;
    }

    public void setLastmodifiedat(Date lastmodifiedat) {
        this.lastmodifiedat = lastmodifiedat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", clientid=").append(clientid);
        sb.append(", scope=").append(scope);
        sb.append(", status=").append(status);
        sb.append(", expiresat=").append(expiresat);
        sb.append(", lastmodifiedat=").append(lastmodifiedat);
        sb.append("]");
        return sb.toString();
    }
}