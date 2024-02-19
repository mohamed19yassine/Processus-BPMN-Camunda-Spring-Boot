package com.example.workflow.controller;

import com.example.workflow.dto.TresRechercherDto;
import com.example.workflow.service.PublicationService;
import com.example.workflow.service.UserTaskService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTaskController {

    @Autowired
    private UserTaskService userTaskService;
    @Autowired
    private PublicationService publicationService;

    @PostMapping("/UserTask/{idTask}")
    public ResponseEntity<String> userTask(@PathVariable String idTask) {
        return userTaskService.simpleTask(idTask);

    }
    @PostMapping("/UserTask/tresRechercher/{idTask}")
    public ResponseEntity<String> tresRechercher(@PathVariable String idTask, @RequestBody TresRechercherDto tresRechercherDto) {
        return userTaskService.recherchSuijet(idTask,tresRechercherDto.isTresRechercher() );

    }
    @PostMapping("/UserTask/exectALL")
    public ResponseEntity<String> exectALLProcess(@RequestBody TresRechercherDto tresRechercherDto) throws InterruptedException {
        String idProcessInstance =publicationService.demarrerProcess();
        Thread.sleep(2000);
        userTaskService.recherchSuijet(idProcessInstance,tresRechercherDto.isTresRechercher() );
        Thread.sleep(2000);

        if(tresRechercherDto.isTresRechercher()){
            userTaskService.simpleTask(idProcessInstance);
            Thread.sleep(2000);
            userTaskService.simpleTask(idProcessInstance);
            Thread.sleep(2000);
            publicationService.notifierMessage();
            Thread.sleep(2000);
            userTaskService.simpleTask(idProcessInstance);
            return ResponseEntity.ok("Le process a exectALL True ok");

        }
        else{
            userTaskService.simpleTask(idProcessInstance);
            return ResponseEntity.ok("Le process a exectALL False ok");

        }
    }


}
