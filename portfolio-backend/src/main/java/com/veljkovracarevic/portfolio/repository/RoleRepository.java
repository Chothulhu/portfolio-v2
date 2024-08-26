package com.veljkovracarevic.portfolio.repository;

import com.veljkovracarevic.portfolio.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
