package com.onekdev.UserForge.repository;

import java.util.Optional;
import java.util.UUID;

import com.onekdev.UserForge.domain.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends CrudRepository<Company, UUID> {
  
    Optional<Company> findByID(UUID ID);
}
