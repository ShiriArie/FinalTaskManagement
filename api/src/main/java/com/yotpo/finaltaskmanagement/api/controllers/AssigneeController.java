package com.yotpo.finaltaskmanagement.api.controllers;

import com.yotpo.finaltaskmanagement.api.converters.AssigneeConverter;
import com.yotpo.finaltaskmanagement.api.converters.TaskConverter;
import com.yotpo.finaltaskmanagement.api.generated.AssigneesApi;
import com.yotpo.finaltaskmanagement.api.generated.model.*;
import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.services.AssigneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RequiredArgsConstructor
@Controller
public class AssigneeController implements AssigneesApi {
    @Autowired
    private AssigneeConverter assigneeConverter;
    @Autowired
    private AssigneeService assigneeService;
    @Autowired
    private TaskConverter taskConverter;


    @Override
    public ResponseEntity<AssigneeResponse> create(AssigneeRequest assigneeRequest) {
        Assignee newAssignee = assigneeService.create(assigneeConverter.assigneeFromRequest(assigneeRequest));
        AssigneeResponse assigneeResponse = assigneeConverter.toAssigneeResponse(newAssignee);
        return ResponseEntity.status(HttpStatus.CREATED).body(assigneeResponse);
    }

    @Override
    public ResponseEntity<AssigneesResponse> index() {
        List<Assignee> assignees = assigneeService.list();
        AssigneesResponse assigneesResponse = assigneeConverter.toAssigneesResponse(assignees);
        return ResponseEntity.ok(assigneesResponse);
    }

    @Override
    public ResponseEntity<AssigneeResponse> findById(Long assigneeId) {
        Assignee assignee = assigneeService.get(assigneeId);
        AssigneeResponse assigneeResponse = assigneeConverter.toAssigneeResponse(assignee);
        return ResponseEntity.ok(assigneeResponse);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        assigneeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TasksResponse> getAllTasks(Long assigneeId) {
        List<Task> assigneeTasks = assigneeService.get(assigneeId).getTasks();
        return ResponseEntity.ok(taskConverter.toTasksResponse(assigneeTasks));
    }

}
