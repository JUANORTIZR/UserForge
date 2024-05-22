package com.onekdev.UserForge.repository;

import com.onekdev.UserForge.domain.model.Company;
import com.onekdev.UserForge.domain.model.Domiciliary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DomiciliaryRepository extends CrudRepository<Domiciliary, UUID> {
    Optional<List<Domiciliary>> findByCompanyId(UUID CompanyId);
}
