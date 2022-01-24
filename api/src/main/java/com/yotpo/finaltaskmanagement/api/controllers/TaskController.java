package com.yotpo.finaltaskmanagement.api.controllers;


import com.yotpo.finaltaskmanagement.api.converters.AssigneeConverter;
import com.yotpo.finaltaskmanagement.api.converters.TaskConverter;
import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.services.AssigneeService;
import com.yotpo.finaltaskmanagement.core.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskConverter taskConverter;
    @Autowired
    private TaskService taskService;



    @PostMapping()
    @RequestMapping("/add")
    public ResponseEntity<String> create(RequestEntity<String> taskRequest) throws JSONException {
        System.out.println("Hi Im inside add");
        Task newTask = taskService.create(taskConverter.taskFromRequest(taskRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskConverter.toTaskResponse(newTask));
    }


}
