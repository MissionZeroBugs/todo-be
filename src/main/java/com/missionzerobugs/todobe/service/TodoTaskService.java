package com.missionzerobugs.todobe.service;

import com.missionzerobugs.todobe.Dto.TodoTaskEntity;
import com.missionzerobugs.todobe.repository.TodoTaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoTaskService {
    private final TodoTaskRepository todoTaskRepository;

    public void populateDB(List<TodoTaskEntity> todoTaskEntityList){
        todoTaskRepository.saveAll(todoTaskEntityList);
    }

    public List<TodoTaskEntity> fetchTodoTaskListByName(String taskName){
        return todoTaskRepository.findByTaskName(taskName);
    }

    public List<TodoTaskEntity> fetchTodoTaskListById(long id){
        return todoTaskRepository.findById(id);
    }
}
