package controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ApplicationController {

@RequestMapping (value = "/test" , method = RequestMethod.GET)
public String test() {
  return "Hello Prabhu, welcome to the group";
}

@RequestMapping("/")
public String index() {
    return "Greetings from Spring Boot!";
}

}
