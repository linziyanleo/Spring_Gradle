package com.example.demo.dao;


import com.example.demo.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao extends JpaRepository<User, Long> {

	Page<User> findByNameContaining(String name, Pageable pageable);

    List<User> findByNameContaining(String name);

    List<User> findByNameContainingAndIdNot(String name, Long id);

    List<User> findByIdNot(Long id);

    Long countByAge(Integer age);


}