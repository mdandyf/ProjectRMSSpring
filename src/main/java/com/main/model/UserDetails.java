package com.main.model;

import java.util.Set;

public class UserDetails {
  private String username;
  private Set<String> listRoles;
  private Set<String> listPrivileges;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Set<String> getListRoles() {
    return listRoles;
  }

  public void setListRoles(Set<String> listRoles) {
    this.listRoles = listRoles;
  }

  public Set<String> getListPrivileges() {
    return listPrivileges;
  }

  public void setListPrivileges(Set<String> listPrivileges) {
    this.listPrivileges = listPrivileges;
  }
}
