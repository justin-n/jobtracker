package com.jobtracker.controller;

import com.jobtracker.entity.JobTime;
import com.jobtracker.service.JobTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
public class JobTrackerController {

    @Autowired
    private JobTimeService jobTimeService;

    @GetMapping(value="/rest/test", produces="text/plain")
    public String helloWorld() {
        return "REST API is working";
    }

    @GetMapping("/rest/jobtimes")
    public List<JobTime> getJobTimes() {
        return jobTimeService.findAll();
    }

    @GetMapping("/rest/weeks")
    public List<Date> getAllWeeks() {
        return jobTimeService.getAllWeeks();
    }

    @GetMapping("/rest/weeks/{firstDayOfWeek}")
    public List<JobTime> getAllJobTimesFromWeek(@PathVariable String firstDayOfWeek) {
        return jobTimeService.getAllJobTimesFromWeek(firstDayOfWeek);
    }

    @PostMapping("/rest/principal")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/rest/authenticationinfo", produces="text/html")
    public String currentUserAuth(Authentication authentication) {

        return
            ("Name:<br />" +
            authentication.getName() + "<br />" +
            "Authorities:<br />" +
            authentication.getAuthorities() + "<br />" +
            "Credentials:<br />" +
            authentication.getCredentials() + "<br />" +
            "Details:<br />" +
            authentication.getDetails() + "<br />" +
            "Is authenticated:<br />" +
            authentication.isAuthenticated() + "<br />" +
            "Class:<br />" +
            authentication.getClass() + "<br />" +
            "Principal:<br />" +
            authentication.getPrincipal());
    }
}
