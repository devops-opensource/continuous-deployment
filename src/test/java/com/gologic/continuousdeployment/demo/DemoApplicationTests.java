package com.gologic.continuousdeployment.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

  @Autowired
  private SayController controller;
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void contexLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

  @Test
  public void sayShouldReturnDefaultMessage() throws Exception {
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("OUPS ! YOU FORGET \"NAME\" QUERY PARAMETER");
  }

  @Test
  public void sayShouldReturnDefinedMessage() throws Exception {
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/?name=bob", String.class)).contains("BOB");
  }

}
