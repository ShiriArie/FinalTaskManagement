package com.yotpo.finaltaskmanagement.core.services;
import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import com.yotpo.finaltaskmanagement.core.entities.Task;
import com.yotpo.finaltaskmanagement.core.exceptions.AssigneeNotFoundException;
import com.yotpo.finaltaskmanagement.core.repositories.AssigneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


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

    public Assignee get(Long id) { return assigneeRepository.findById(id)
            .orElseThrow(() -> new AssigneeNotFoundException(id)); }

    public void delete(Long id) {
        //Also need to check for children records before deleting.
        assigneeRepository.deleteById(id);
    }

    public Assignee getByFirstNameAndLastName(String firstName, String lastName){
        List<Assignee> assignees = list();
        synchronized (assignees){
            Iterator<Assignee> iterator = assignees.iterator();
            while(iterator.hasNext()){
                Assignee assignee = (Assignee) iterator.next();
                if (assignee.getFirst_name().equals(firstName)
                        && assignee.getLast_name().equals(lastName)) {
                    return assignee;
                }
            }
            return null;
        }
    }

}