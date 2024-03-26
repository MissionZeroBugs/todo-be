package com.missionzerobugs.todobe;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class IntegrationTestConfiguration {
    private WireMockServer wireMockServer;

    @Value("${wiremock.host}")
    private String host;

    @Value("${wiremock.port}")
    private int port;

    @PostConstruct
    public void create(){
        wireMockServer = new WireMockServer(port);
        wireMockServer.start();
        WireMock.configureFor(host, port);
    }

    @PreDestroy
    public void destroy(){
        wireMockServer.stop();
    }
}
