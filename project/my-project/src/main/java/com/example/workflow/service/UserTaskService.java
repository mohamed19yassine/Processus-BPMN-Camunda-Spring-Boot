package com.example.workflow.service;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserTaskService    {
    @Autowired
    private TaskService taskService;

    public ResponseEntity<String> simpleTask(String idTask){
        // Fetch user task by task ID
        Task userTask = taskService.createTaskQuery()
                .processInstanceId(idTask)
                .singleResult();

        if (userTask != null) {
            System.out.println(userTask.getName());
            taskService.complete(userTask.getId());
            return ResponseEntity.ok("User task completed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User task not found.");
        }
    }
    public ResponseEntity<String> recherchSuijet (String idTask,Boolean tresRechercher) {
        Task userTask = taskService.createTaskQuery()
                .processInstanceId(idTask)
                .singleResult();
        System.out.println(userTask.toString());
        if (userTask != null) {
            System.out.println(userTask.getName());
            taskService.setVariable(userTask.getId(),"tresRechercher",tresRechercher);
            taskService.complete(userTask.getId());
            return ResponseEntity.ok("User task completed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User task not found.");
        }



    }




}
