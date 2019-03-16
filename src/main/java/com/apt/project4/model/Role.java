package com.apt.project4.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Enumerated(EnumType.STRING)
//    private RoleName roleName;
    @Column(name = "role_name", length = 20)
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleName == role.roleName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
}
