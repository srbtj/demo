package com.srbtj.demo.entity;

import java.io.Serializable;

public class UserRole implements Serializable {

    private Integer id;
    private String roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}
