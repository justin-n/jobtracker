package com.jobtracker.repository;

import com.jobtracker.entity.JobTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTimeRepository extends CrudRepository<JobTime, Long> {
}
