package com.kosh.simplehttp.ControllersTests;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.kosh.simplehttp.controllers.HelloController;
import com.kosh.simplehttp.services.ReaderService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTests {

    @Test
    public void contextLoads() throws Exception {
    }

    @Autowired
    private HelloController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ReaderService service;

    @Test
    public void controllerLoads() throws Exception {
      assertTrue(controller != null);
    }

    @Test
    public void emptyPeopleOnFirstCall() {
        String getResult = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertTrue(getResult.contains("[]"));
    }
}
