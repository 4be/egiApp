package com.egiapp.demo.repository;

import com.egiapp.demo.model.entity.ERole;
import com.egiapp.demo.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRolename(ERole nameRole);
}
