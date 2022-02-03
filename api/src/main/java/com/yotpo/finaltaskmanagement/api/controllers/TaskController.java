package com.yotpo.finaltaskmanagement.api.controllers;


import com.yotpo.finaltaskmanagement.api.converters.AssigneeConverter;
import com.yotpo.finaltaskmanagement.api.converters.TaskConverter;
import com.yotpo.finaltaskmanagement.api.generated.model.TaskRequest;
import com.yotpo.finaltaskmanagement.api.generated.model.TaskResponse;
import com.yotpo.finaltaskmanagement.api.generated.model.TasksResponse;
import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.services.AssigneeService;
import com.yotpo.finaltaskmanagement.core.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.yotpo.finaltaskmanagement.api.generated.TasksApi;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TaskController implements TasksApi {

    @Autowired
    private TaskConverter taskConverter;
    @Autowired
    private TaskService taskService;


    @Override
    public ResponseEntity<TaskResponse> create(TaskRequest taskRequest) {
        Task newTask = taskService.create(taskConverter.taskFromRequest(taskRequest));
        TaskResponse taskResponse = taskConverter.toTaskResponse(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @Override
    public ResponseEntity<TasksResponse> index() {
        List<Task> tasks = taskService.list();
        TasksResponse tasksResponse = taskConverter.toTasksResponse(tasks);
        return ResponseEntity.ok(tasksResponse);
    }

    @Override
    public ResponseEntity<TaskResponse> findById(Long taskId) {
        Task task = taskService.get(taskId);
        TaskResponse taskResponse = taskConverter.toTaskResponse(task);
        return ResponseEntity.ok(taskResponse);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TaskResponse> update(Long id, TaskRequest taskRequest) {
        Task task = taskConverter.taskFromRequest(taskRequest);
        task.setTask_id(id);
        Task updatedTask = taskService.update(task);
        return ResponseEntity.ok(taskConverter.toTaskResponse(updatedTask));
    }

}
