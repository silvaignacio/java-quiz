package com.iandsilvas.bcpquiz.repository;

import com.iandsilvas.bcpquiz.domain.ERole;
import com.iandsilvas.bcpquiz.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}