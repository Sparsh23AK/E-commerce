package com.sghc.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghc.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
