package com.yotpo.finaltaskmanagement.core.services;

import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.exceptions.AssigneeNotFoundException;
import com.yotpo.finaltaskmanagement.core.exceptions.TaskNotFoundException;
import com.yotpo.finaltaskmanagement.core.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task create(Task task) {return taskRepository.save(task); }

    public List<Task> list() { return (List<Task>) taskRepository.findAll(); }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task get(Long id) { return taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id)); }

//    public Task update(Long id, Task task) {
//        Task existingTask = get(id);
//        BeanUtils.copyProperties(task, existingTask, "task_id");
//        return taskRepository.save(existingTask);
//    }
    public Task update(Task task) {
        Long id = task.getTask_id();
        Task existingTask = get(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setStatus(task.getStatus());
        existingTask.setDue_date(task.getDue_date());
        existingTask.setAssignee(task.getAssignee());
        return taskRepository.save(existingTask);
    }






}