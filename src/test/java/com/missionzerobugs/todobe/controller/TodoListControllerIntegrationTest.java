package com.missionzerobugs.todobe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TodoListController todoListController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getTodoList() {
        assertThat(todoListController).isNotNull();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains(List.of("Hello", "World"));
    }
}