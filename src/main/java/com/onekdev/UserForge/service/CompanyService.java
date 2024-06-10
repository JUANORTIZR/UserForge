package com.onekdev.UserForge.service;

import java.util.ArrayList;
import java.util.UUID;

import com.onekdev.UserForge.commons.BusinessException;
import com.onekdev.UserForge.config.kafka.MessageProducer;
import com.onekdev.UserForge.config.mappers.CompanyMapper;
import com.onekdev.UserForge.domain.model.Company;
import com.onekdev.UserForge.domain.request.AuthRequest;
import com.onekdev.UserForge.domain.request.CompanyPatchRequest;
import com.onekdev.UserForge.domain.request.CompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.onekdev.UserForge.domain.response.CompanyResponse;
import com.onekdev.UserForge.repository.CompanyRepository;

@Service
public class CompanyService {
    

    private final CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private MessageProducer messageProducer;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public CompanyResponse createCompany(CompanyRequest companyRequest) {

        Company company = new Company(companyRequest);
        try {
            CompanyResponse response = new CompanyResponse(companyRepository.save(company));
            AuthRequest authRequest = new AuthRequest();
            authRequest.setNickname(response.getNickname());
            messageProducer.sendMessage("toChangeRol",authRequest.toJsonString());
            return response;
        } catch (Exception e) {
            throw new BusinessException("No se pudo crear la compañia",CompanyService.class.getName(), e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public CompanyResponse getCompanyById(UUID id) {
        Company company = companyRepository
                .findByID(id)
                .orElseThrow(() -> new BusinessException("No hay usuarios registrados con ese id",
                        CompanyService.class.getName(),
                        "Error con la libreria hibernate",
                        HttpStatus.NOT_FOUND));
        return new CompanyResponse(company);
    }

    public ArrayList<Company> getCompanies(){
        try{
            return (ArrayList<Company>) companyRepository.findAll();
        }
        catch(Exception e) {
            throw new BusinessException("Error al consultar compañias registradas", CompanyService.class.getName(),e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public CompanyResponse patchCompany(CompanyPatchRequest companyPatchRequest, UUID companyId){
        try{
            Company companyUpdated = companyRepository.findByID(companyId).orElseThrow(() -> new BusinessException("No hay usuarios registrados con ese id",
                    CompanyService.class.getName(),
                    "Error con la libreria hiernate",
                    HttpStatus.NOT_FOUND));
            companyUpdated.merge(companyMapper.toCompany(companyPatchRequest));
            companyUpdated = companyRepository.save(companyUpdated);
            return new CompanyResponse(companyUpdated);
        }
        catch(Exception e) {
            throw new BusinessException("Error al actualizar la compañia", CompanyService.class.getName(), e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
