package com.yotpo.finaltaskmanagement.core.entities;


import lombok.Builder;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.time.LocalDate;

@Entity(name= "tasks")
@SuperBuilder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long task_id;

    private String title;
    private String status;
    private LocalDate due_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private Assignee assignee;

    public Task() {
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long id) {
        this.task_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate dueDate) {
        this.due_date = dueDate;
    }


}