package com.missionzerobugs.todobe.controller;

import com.missionzerobugs.todobe.Dto.TodoTaskEntity;
import com.missionzerobugs.todobe.service.TodoTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static io.micrometer.common.util.StringUtils.isNotEmpty;
import static java.lang.Long.parseLong;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class TodoListController {
    private final TodoTaskService todoTaskService;

    @GetMapping("/todo-task")
    public List<TodoTaskEntity> getTodoList(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "taskName", required = false) String taskName){
        if(isNotEmpty(taskName)){
            return todoTaskService.fetchTodoTaskListByName(taskName);
        }
        if(isNotEmpty(id)){
            return todoTaskService.fetchTodoTaskListById(parseLong(id));
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @PostMapping(value = "/populate-database")
    public String populateDatabase(@RequestBody List<TodoTaskEntity> todoTaskEntityList){
        todoTaskService.populateDB(todoTaskEntityList);
        return "DB populated!";
    }

}
