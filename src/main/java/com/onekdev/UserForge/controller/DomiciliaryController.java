package com.onekdev.UserForge.controller;

import com.onekdev.UserForge.domain.model.Domiciliary;
import com.onekdev.UserForge.domain.request.DomiciliaryRequest;
import com.onekdev.UserForge.service.DomiciliaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Domiciliary")
public class DomiciliaryController {

    private final DomiciliaryService domiciliaryService;

    public DomiciliaryController(DomiciliaryService domiciliaryService) {
        this.domiciliaryService = domiciliaryService;
    }

    @PostMapping
    public ResponseEntity<Domiciliary> registry(@RequestBody DomiciliaryRequest domiciliaryRequest){
        return ResponseEntity.ok().body(domiciliaryService.createDomiciliary(domiciliaryRequest));
    }

    @GetMapping
    public  ResponseEntity<ArrayList<Domiciliary>> getAll(){
        return ResponseEntity.ok().body(domiciliaryService.getAll());
    }

    @GetMapping("/by")
    public ResponseEntity<ArrayList<Domiciliary>> getByCompanyId(@RequestParam UUID companyId){
        return ResponseEntity.ok().body(domiciliaryService.getByIdCompany(companyId));
    }



}
