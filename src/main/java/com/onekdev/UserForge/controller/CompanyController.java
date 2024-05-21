package com.onekdev.UserForge.controller;

import java.util.ArrayList;
import java.util.List;

import com.onekdev.UserForge.domain.model.Company;
import com.onekdev.UserForge.domain.request.CompanyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onekdev.UserForge.domain.response.CompanyResponse;
import com.onekdev.UserForge.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Company")
public class CompanyController {
    
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping()
    public ResponseEntity<CompanyResponse> login(@RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.ok().body(companyService.createCompany(companyRequest));
    }

    @GetMapping("/by")
    public ResponseEntity<CompanyResponse> getByID(@RequestParam Long id) {
        return ResponseEntity.ok().body(companyService.getCompanyById(id));
    }

    @GetMapping()
    public ResponseEntity<ArrayList<Company>> getUsers() {
        return ResponseEntity.ok().body(companyService.getCompanies());
    }


}
