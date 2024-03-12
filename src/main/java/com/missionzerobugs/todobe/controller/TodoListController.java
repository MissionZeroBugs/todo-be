package com.missionzerobugs.todobe.controller;

import com.missionzerobugs.todobe.Dto.TodoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoListController {

    @GetMapping("/")
    public List<String> getTodoList(){
        TodoTask todoTask = new TodoTask();
        todoTask.setId(123);
        todoTask.getId();
        return List.of("Hello", "World");
    }

}
