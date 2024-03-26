package com.missionzerobugs.todobe.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.missionzerobugs.todobe.Dto.TodoTaskEntity;
import com.missionzerobugs.todobe.repository.TodoTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TodoListControllerIntegrationTest {
    private static final String TODO_TASK_URL = "/todo-task";
    @Autowired
    private TodoListController todoListController;

    @Autowired
    private WebTestClient webTestClient;

    @Spy
    private TodoTaskRepository todoTaskRepository;

    @BeforeEach
    public void init(){
        WireMock.reset();
    }

    @BeforeEach
    public void setUp(){
        todoTaskRepository.save(new TodoTaskEntity(1L, "Hello"));
        todoTaskRepository.save(new TodoTaskEntity(2L, "World"));
    }

    @Test
    void getTodoList() {
        todoTaskRepository.save(new TodoTaskEntity(1L, "Hello"));
        todoTaskRepository.save(new TodoTaskEntity(2L, "World"));
        assertThat(todoListController).isNotNull();

        webTestClient
                .get()
                .uri(TODO_TASK_URL)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println);
    }
}