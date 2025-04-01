package net.javaguides.spring_boot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
    // Http Get Request
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}
