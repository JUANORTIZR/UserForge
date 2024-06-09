package com.onekdev.UserForge.service;

import com.onekdev.UserForge.commons.BusinessException;
import com.onekdev.UserForge.config.kafka.MessageProducer;
import com.onekdev.UserForge.config.mappers.DomiciliaryMapper;
import com.onekdev.UserForge.domain.model.Domiciliary;
import com.onekdev.UserForge.domain.request.DomiciliaryRequest;
import com.onekdev.UserForge.repository.DomiciliaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class DomiciliaryService {

    private final DomiciliaryRepository domiciliaryRepository;

    @Autowired
    private DomiciliaryMapper domiciliaryMapper;

    @Autowired
    private MessageProducer messageProducer;

    public DomiciliaryService(DomiciliaryRepository domiciliaryRepository) {
        this.domiciliaryRepository = domiciliaryRepository;
    }

    public ArrayList<Domiciliary> getAll(){
        try {
            return (ArrayList<Domiciliary>) domiciliaryRepository.findAll();
        }
        catch (Exception e) {
            throw new BusinessException("Error al consultar los domiciliarios",DomiciliaryService.class.getName(), e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ArrayList<Domiciliary> getByIdCompany(UUID companyId){
        return (ArrayList<Domiciliary>) domiciliaryRepository.findByCompanyId(companyId)
                .orElseThrow(()->new BusinessException("Error al intentar consultar domiciliarios por id de la compañia",
                        DomiciliaryService.class.getName(),
                        "Error con la libreria hibernate",
                        HttpStatus.INTERNAL_SERVER_ERROR));
    }

    public Domiciliary createDomiciliary(DomiciliaryRequest domiciliaryRequest){
        try {
             Domiciliary domiciliary = domiciliaryMapper.toDomiciliary(domiciliaryRequest);
             domiciliary = domiciliaryRepository.save(domiciliary);
             messageProducer.sendMessage(domiciliaryMapper.toAuthentication(domiciliaryRequest).toJsonString());
             return domiciliary;
        }
        catch (Exception e) {
            throw new BusinessException("Error al crear domiciliario",DomiciliaryService.class.getName(), e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
