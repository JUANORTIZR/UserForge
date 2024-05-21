package com.onekdev.UserForge.repository;

import java.util.List;
import java.util.Optional;

import com.onekdev.UserForge.domain.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onekdev.UserForge.domain.model.User;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
  
    Optional<Company> findByID(long ID);
}
