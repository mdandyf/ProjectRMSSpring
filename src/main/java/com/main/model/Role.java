package com.main.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "role_name")
  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JsonManagedReference
  @JoinTable(name = "role_privilege",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
  private List<Privilege> privileges;

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

  public List<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(List<Privilege> privileges) {
    this.privileges = privileges;
  }
}
