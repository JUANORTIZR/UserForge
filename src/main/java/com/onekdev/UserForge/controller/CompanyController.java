package com.onekdev.UserForge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.onekdev.UserForge.domain.model.Company;
import com.onekdev.UserForge.domain.request.CompanyPatchRequest;
import com.onekdev.UserForge.domain.request.CompanyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.onekdev.UserForge.domain.response.CompanyResponse;
import com.onekdev.UserForge.service.CompanyService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Company")
public class CompanyController {
    
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping()
    public ResponseEntity<CompanyResponse> registry(@RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.ok().body(companyService.createCompany(companyRequest));
    }

    @GetMapping("/by")
    public ResponseEntity<CompanyResponse> getByID(@RequestParam UUID id) {
        return ResponseEntity.ok().body(companyService.getCompanyById(id));
    }

    @GetMapping()
    public ResponseEntity<ArrayList<Company>> getCompanies() {
        return ResponseEntity.ok().body(companyService.getCompanies());
    }

    @PatchMapping()
    public ResponseEntity<CompanyResponse> updateCompany(@RequestBody CompanyPatchRequest companyPatchRequest, @RequestParam UUID id) {
        return ResponseEntity.ok().body(companyService.patchCompany(companyPatchRequest,id));
    }



}
