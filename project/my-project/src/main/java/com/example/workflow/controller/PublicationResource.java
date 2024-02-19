package com.example.workflow.controller;

import com.example.workflow.service.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationResource {
    private PublicationService publicationService;

    public PublicationResource(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/demarrer-process")
    public ResponseEntity<String>demarrerProcess(){
       String idProcessInstance = publicationService.demarrerProcess();
        return ResponseEntity.ok("Le process a demarré ");

    }
    @GetMapping("/video-editee")
    public ResponseEntity<String>notifierVideoEditee(){
        publicationService.notifierMessage();
        return ResponseEntity.ok("La notification a été envoyéé");

    }
}
