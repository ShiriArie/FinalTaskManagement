package com.yotpo.finaltaskmanagement.core.repositories;

import com.yotpo.finaltaskmanagement.core.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
