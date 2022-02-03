package com.yotpo.finaltaskmanagement.api.converters;

import com.yotpo.finaltaskmanagement.api.generated.model.*;
import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskConverter {

    @Autowired
    private AssigneeConverter assigneeConverter;

    public Task taskFromRequest(TaskRequest taskRequest) {
        TaskRequestTask task = taskRequest.getTask();
        return Task.builder()
                .title(task.getTitle())
                .due_date(task.getDueDate())
                .status(task.getStatus())
                .assignee(assigneeConverter.assigneeFromRequest(task.getAssignee()))
                .build();

    }

    public TaskResponse toTaskResponse(Task task){
        TaskResponseTask taskResponseTask = new TaskResponseTask();
        taskResponseTask.setTitle(task.getTitle());
        taskResponseTask.setStatus(task.getStatus());
        taskResponseTask.setTaskId(task.getTask_id());
        taskResponseTask.setDueDate(task.getDue_date());
        taskResponseTask.setAssignee(assigneeConverter.toAssigneeResponse(task.getAssignee()));
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTask(taskResponseTask);
        return taskResponse;
    }

    public TasksResponse toTasksResponse(List<Task> tasks){
        List<TaskResponse> taskResponses = tasks.stream().map(
                this::toTaskResponse
        ).collect(Collectors.toList());

        TasksResponse response = new TasksResponse();
        response.setTasks(taskResponses);
        return response;
    }

}
