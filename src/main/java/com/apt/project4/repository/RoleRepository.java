package com.apt.project4.repository;

import com.apt.project4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    //    @Query(value = "select r from Role where r.roleName.toString() = :roleName")
//    Role findByRoleName(@Param("roleName") RoleName roleName);
    Role findByRoleName(String roleName);
}
