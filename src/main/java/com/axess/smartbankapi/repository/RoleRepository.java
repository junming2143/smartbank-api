package com.axess.smartbankapi.repository;

import com.axess.smartbankapi.model.CCUser;
import com.axess.smartbankapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
