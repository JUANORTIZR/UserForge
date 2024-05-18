package com.onekdev.UserForge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onekdev.UserForge.domain.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  
    Optional<User> findByID(long ID);

    Optional<List<User>> findByRol(String Rol);
}
