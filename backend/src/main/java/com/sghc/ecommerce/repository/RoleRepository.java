package com.sghc.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghc.ecommerce.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
