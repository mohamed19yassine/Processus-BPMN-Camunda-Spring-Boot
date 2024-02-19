package com.example.workflow.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {

    @Autowired
    private ProcessEngine processEngine;


    public String demarrerProcess() {
        System.out.println("Le process a demarré");
       return processEngine.getRuntimeService()
                .startProcessInstanceByMessage("NouvelleIdee","pub-1").getProcessInstanceId();
    }

    public void notifierMessage() {
        System.out.println("La notification a été envoyéé");
        processEngine.getRuntimeService()
                .correlateMessage("VideoEditee","pub-1");//"pub-1" cad en a spesifiee le bessnes key
    }


}
