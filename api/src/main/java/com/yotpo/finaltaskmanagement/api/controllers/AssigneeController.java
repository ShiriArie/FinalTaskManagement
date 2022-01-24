package com.yotpo.finaltaskmanagement.api.controllers;

import com.yotpo.finaltaskmanagement.api.converters.AssigneeConverter;
import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.services.AssigneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RequiredArgsConstructor
@Controller
@RequestMapping("/assignees")
public class AssigneeController {
    @Autowired
    private AssigneeConverter assigneeConverter;
    @Autowired
    private AssigneeService assigneeService;

    @PostMapping()
    @RequestMapping("/add")
    public ResponseEntity<String> create(RequestEntity<String> assigneeRequest) throws JSONException {
        System.out.println("Hi Im inside add");
        Assignee newAssignee = assigneeService.create(assigneeConverter.assigneeFromRequest(assigneeRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(assigneeConverter.toAssigneeResponse(newAssignee));
    }

    @GetMapping()
    @RequestMapping("/getAll")
    public ResponseEntity<String> getAll(){
        System.out.println("Hi Im inside getAll");
        List<Assignee> assignees = assigneeService.list();
        return ResponseEntity.status(HttpStatus.FOUND).body(assigneeConverter.toAssigneesResponse(assignees));
    }


    @RequestMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable Long id) {
        System.out.println("Hi Im inside get id " + id);
        Assignee assignee = assigneeService.get(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(assigneeConverter.toAssigneeResponse(assignee));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        assigneeService.delete(id);
        return ResponseEntity.status(HttpStatus.FOUND).body("Assignee with id:" + id + " has removed");
    }


}
