package com.yotpo.finaltaskmanagement.core.repositories;

import com.yotpo.finaltaskmanagement.core.entities.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {


}
