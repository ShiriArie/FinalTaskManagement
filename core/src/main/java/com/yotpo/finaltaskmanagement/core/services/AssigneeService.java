package com.yotpo.finaltaskmanagement.core.services;
import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.repositories.AssigneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AssigneeService {
    @Autowired
    private AssigneeRepository assigneeRepository;

    public Assignee create(Assignee assignee) {
        return assigneeRepository.save(assignee);
    }

    public List<Assignee> list() {
        return (List<Assignee>) assigneeRepository.findAll();

    }
    public Optional<Assignee> get(Long id) {
        return assigneeRepository.findById(id);
    }

//    public void delete(Long id) {
//        //Also need to check for children records before deleting.
//        assigneeRepository.deleteByassignee_id(id);
//    }

    public void deleteById(Long id) {
        assigneeRepository.deleteById(id);
    }






}