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
        System.out.println("assignee: "+ obj.getJSONObject("assignee").toString());
        return Task.builder()
                .title(obj.getString("title"))
                .status(obj.getString("status"))
                .assignee(assigneeConverter.assigneeFromJSONObject(obj.getJSONObject("assignee")))
                .due_date(LocalDate.parse(obj.getString("due_date")))
                .build();

    }


    public String toTaskResponse(Task task){
        System.out.println(assigneeConverter.toAssigneeResponse(task.getAssignee()));
        try{
            return new JSONObject()
                    .put("title", task.getTitle())
                    .put("task_id", task.getTask_id())
                    .put("status", task.getStatus())
                    .put("assignee", assigneeConverter.JSONObjectFromAssignee(task.getAssignee()))
                    .put("due_date", task.getDue_date())
                    .toString();

        } catch (JSONException e) {
            e.printStackTrace();
            return "Failed to create JSON from Task";
        }
    }


    public String toTasksResponse(List<Task> tasks){
        return tasks.stream().map(this::toTaskResponse).collect(Collectors.toList()).toString();
    }


}
