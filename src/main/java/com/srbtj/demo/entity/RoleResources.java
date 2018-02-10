package com.srbtj.demo.entity;

import java.io.Serializable;

public class RoleResources implements Serializable{

    private Integer roleid;
    private String resourcesId;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
    }
}
