package com.yotpo.finaltaskmanagement.api.converters;

import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.services.AssigneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.RequestEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AssigneeConverter {

    @Autowired
    private TaskConverter taskConverter;
    @Autowired
    private AssigneeService assigneeService;

    public Assignee assigneeFromRequest(RequestEntity<String> request) throws JSONException {
        return (assigneeFromJSONObject(new JSONObject(request.getBody())));
    }

    public Assignee assigneeFromJSONObject(JSONObject obj) throws JSONException {
        if (obj.has("assignee_id")){
            Assignee assignee = assigneeService.get(obj.getLong("assignee_id"));
            return assignee;
        }
        else{
            Assignee assignee = Assignee.builder()
                    .first_name(obj.getString("first_name"))
                    .last_name(obj.getString("last_name"))
                    .build();
            assigneeService.create(assignee);
            return assignee;
        }
    }

    public JSONObject JSONObjectFromAssignee(Assignee assignee) {
        try{
            return new JSONObject()
                    .put("assignee_id", assignee.getAssignee_id())
                    .put("first_name", assignee.getFirst_name())
                    .put("last_name", assignee.getLast_name());


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String toAssigneeResponse(Assignee assignee){
        try{
            return new JSONObject()
                    .put("assignee_id", assignee.getAssignee_id())
                    .put("first_name", assignee.getFirst_name())
                    .put("last_name", assignee.getLast_name())
//                    .put("tasks", assignee.getTasks())
                    .toString();

        } catch (JSONException e) {
            e.printStackTrace();
            return "Failed to create JSON from Assignee";
        }
    }

    public String toAssigneesResponse(List<Assignee> assignees){
        return assignees.stream().map(this::toAssigneeResponse).collect(Collectors.toList()).toString();
    }









}
