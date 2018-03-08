package com.gologic.continuousdeployment.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayController {

  @GetMapping("/")
  public @ResponseBody String say(@RequestParam(name = "name", required = false, defaultValue = "Oups ! you forget \"name\" query parameter") String name) {
    return name.toUpperCase();
  }
}
