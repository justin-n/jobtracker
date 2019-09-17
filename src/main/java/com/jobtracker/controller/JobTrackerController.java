package com.jobtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobTrackerController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "hello world";
    }

}
