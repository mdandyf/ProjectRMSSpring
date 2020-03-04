package com.main.model;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String name;
    private Set<String> listRoles;

    public UserDTO(Long id, String name, Set<String> listRoles) {
        this.id = id;
        this.name = name;
        this.listRoles = listRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<String> listRoles) {
        this.listRoles = listRoles;
    }
}
