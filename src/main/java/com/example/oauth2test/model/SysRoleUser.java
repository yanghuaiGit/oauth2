package com.example.oauth2test.model;

import java.io.Serializable;

public class SysRoleUser implements Serializable {
    private Integer sysUserId;

    private Integer rolesId;

    private static final long serialVersionUID = 1L;

    public Integer getSysUserId() {
        return sysUserId;
    }

    public SysRoleUser withSysUserId(Integer sysUserId) {
        this.setSysUserId(sysUserId);
        return this;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public SysRoleUser withRolesId(Integer rolesId) {
        this.setRolesId(rolesId);
        return this;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", rolesId=").append(rolesId);
        sb.append("]");
        return sb.toString();
    }
}