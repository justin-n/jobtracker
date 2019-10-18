package com.jobtracker.controller;

import com.jobtracker.entity.JobTime;
import com.jobtracker.service.JobTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class JobTimeController {

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

    @PostMapping("/rest/timeentry")
    public void addTimeEntry(@RequestBody JobTime jobTime) {
        jobTimeService.addJobTime(jobTime);
    }
}
