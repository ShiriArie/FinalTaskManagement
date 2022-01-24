package com.yotpo.finaltaskmanagement.core.entities;

import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.*;

@Entity(name= "assignees")
@SuperBuilder
public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assignee_id;

    private String first_name;
    private String last_name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignee")
    private List<Task> tasks;

    public Assignee() {
    }

    public Map<String, String> ToMap(Assignee assignee) {
        Map<String, String> assigneeMap = new HashMap<>();
        assigneeMap.put("assignee_id", assignee.assignee_id.toString());
        assigneeMap.put("first_name", assignee.first_name);
        assigneeMap.put("last_name", assignee.last_name);
        return assigneeMap;
    }



    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Long getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(Long id) {
        this.assignee_id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}