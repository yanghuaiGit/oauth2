package com.example.oauth2test.model;

import java.io.Serializable;

public class SysPermission implements Serializable {
    private Integer id;

    private String name;

    private String descritpion;

    private String url;

    private Integer pid;

    private String method;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public SysPermission withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SysPermission withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescritpion() {
        return descritpion;
    }

    public SysPermission withDescritpion(String descritpion) {
        this.setDescritpion(descritpion);
        return this;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion == null ? null : descritpion.trim();
    }

    public String getUrl() {
        return url;
    }

    public SysPermission withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public SysPermission withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMethod() {
        return method;
    }

    public SysPermission withMethod(String method) {
        this.setMethod(method);
        return this;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", descritpion=").append(descritpion);
        sb.append(", url=").append(url);
        sb.append(", pid=").append(pid);
        sb.append(", method=").append(method);
        sb.append("]");
        return sb.toString();
    }
}