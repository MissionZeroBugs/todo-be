package com.missionzerobugs.todobe.repository;

import com.missionzerobugs.todobe.Dto.TodoTaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoTaskRepository extends CrudRepository<TodoTaskEntity, Long> {
    List<TodoTaskEntity> findById(long id);

    List<TodoTaskEntity> findByTaskName(String taskName);
}
