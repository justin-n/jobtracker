package com.jobtracker.service;

import com.jobtracker.entity.JobTime;
import com.jobtracker.repository.JobTimeRepository;
import com.jobtracker.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Date> getAllWeeks() {

        List<JobTime> jobTimes = new ArrayList<>();
        jobTimeRepository.findAll().forEach(jobTimes::add);
        return DateUtil.getListOfFirstMondaysFromListOfJobTimes(jobTimes);
    }

    public List<JobTime> getAllJobTimesFromWeek(String firstDayOfWeek) {
        List<JobTime> jobTimes = new ArrayList<>();
        jobTimeRepository.findAll().forEach(jobTimes::add);
        return DateUtil.getJobTimesWithinMondayWeek(jobTimes, firstDayOfWeek);
    }
}
