package com.main.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {
  @NotNull
  @Size(min = 5, message = "minimum name size is 5 characters")
  private String name;
  @NotNull
  @Size(min = 5, message = "minimum username size is 5 characters")
  private String userName;
  @NotNull
  @Size(min = 2, message = "minimum password size is 2 characters")
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
