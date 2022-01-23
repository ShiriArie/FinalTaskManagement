package com.yotpo.finaltaskmanagement.core.services;

import com.yotpo.finaltaskmanagement.core.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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





}