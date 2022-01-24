package com.yotpo.finaltaskmanagement.api.converters;

import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryBuilder;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
    @Autowired
    private AssigneeService assigneeService;

    public Task taskFromRequest(RequestEntity<String> request) throws JSONException {
        return (taskFromJSONObject(new JSONObject(request.getBody())));
    }

    public List<Task> tasksFromRequest(RequestEntity<String> request) throws JSONException {
        JSONArray objs = new JSONArray(request.getBody());
        List<Task> tasks= new ArrayList<>();
        for (int i=0; i< objs.length(); i++){
            tasks.add(taskFromJSONObject(objs.getJSONObject(i)));
        }
        return tasks;
    }

    public Task taskFromJSONObject(JSONObject obj) throws JSONException {
        return Task.builder()
                .task_id(obj.getLong("task_id"))
                .title(obj.getString("title"))
                .status(obj.getString("status"))
                .assignee(assigneeConverter.assigneeFromJSONObject(obj.getJSONObject("assignee")))
//                .assignee(assigneeService.get(obj.getLong("assignee")))
                .due_date(LocalDate.parse(obj.getString("due_date")))
                .build();

    }


    public String toTaskResponse(Task task){
        try{
            return new JSONObject()
                    .put("task_id", task.getTask_id())
                    .put("status", task.getStatus())
                    .put("assignee", assigneeConverter.toAssigneeResponse(task.getAssignee()))
                    .put("due_date", task.getDue_date().toString())
                    .toString();

        } catch (JSONException e) {
            e.printStackTrace();
            return "Failed to create JSON from Task";
        }
    }


    public List<String> toTasksResponse(List<Task> tasks){
        return tasks.stream().map(this::toTaskResponse).collect(Collectors.toList());
    }


}
