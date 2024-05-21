package com.onekdev.UserForge.config.mappers;

import com.onekdev.UserForge.domain.model.Company;
import com.onekdev.UserForge.domain.request.CompanyPatchRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper MAPPER = Mappers.getMapper( CompanyMapper.class );

    Company toCompany(CompanyPatchRequest companyPatchRequest);
}