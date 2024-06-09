package com.onekdev.UserForge.config.mappers;

import com.onekdev.UserForge.domain.model.Domiciliary;
import com.onekdev.UserForge.domain.request.AuthRequest;
import com.onekdev.UserForge.domain.request.DomiciliaryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DomiciliaryMapper {

    CompanyMapper MAPPER = Mappers.getMapper( CompanyMapper.class );

    Domiciliary toDomiciliary(DomiciliaryRequest domiciliaryRequest);
    AuthRequest toAuthentication(DomiciliaryRequest domiciliaryRequest);
}
