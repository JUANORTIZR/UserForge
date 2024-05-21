package com.onekdev.UserForge.service;

import java.util.ArrayList;

import com.onekdev.UserForge.commons.BusinessException;
import com.onekdev.UserForge.domain.model.Company;
import com.onekdev.UserForge.domain.request.CompanyRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.onekdev.UserForge.domain.response.CompanyResponse;
import com.onekdev.UserForge.repository.CompanyRepository;

@Service
public class CompanyService {
    

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public CompanyResponse createCompany(CompanyRequest companyRequest) {

        Company company = new Company(companyRequest);
        try {
            return new CompanyResponse(companyRepository.save(company));
        } catch (Exception e) {
            throw new BusinessException("No se pudo crear la compañia",CompanyService.class.getName(), HttpStatus.BAD_REQUEST);
        }
    }

    public CompanyResponse getCompanyById(Long id) {
        Company company = companyRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("No hay usuarios registrados con ese id",
                                                            CompanyService.class.getName(),
                                                            HttpStatus.NOT_FOUND));
        return new CompanyResponse(company);
    }

    public ArrayList<Company> getCompanies(){
        return (ArrayList<Company>) companyRepository.findAll();
    }

}
