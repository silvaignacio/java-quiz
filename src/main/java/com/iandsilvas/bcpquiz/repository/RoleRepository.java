package com.iandsilvas.bcpquiz.repository;

import com.iandsilvas.bcpquiz.domain.ERole;
import com.iandsilvas.bcpquiz.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}