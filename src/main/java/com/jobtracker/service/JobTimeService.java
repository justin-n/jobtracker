package com.jobtracker.service;

import com.jobtracker.entity.JobTime;
import com.jobtracker.repository.JobTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobTimeService {

    @Autowired
    private JobTimeRepository jobTimeRepository;

    public JobTimeService() { }

    public List<JobTime> findAll() {

        List<JobTime> jobTimes = new ArrayList<>();

        jobTimeRepository.findAll().forEach(jobTimes::add);

        return jobTimes;
    }
}
