package com.jobtracker.repository;

import com.jobtracker.entity.JobTime;
import org.springframework.data.repository.CrudRepository;

public interface JobTimeRepository extends CrudRepository<JobTime, Long> {
}
