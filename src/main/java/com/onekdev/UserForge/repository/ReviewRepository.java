package com.onekdev.UserForge.repository;


import com.onekdev.UserForge.domain.model.Domiciliary;
import com.onekdev.UserForge.domain.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository extends CrudRepository<Review, UUID> {
    Optional<List<Review>> findByCompanyId(UUID CompanyId);

}
