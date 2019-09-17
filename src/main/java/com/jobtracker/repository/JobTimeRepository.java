package com.jobtracker.repository;

import org.springframework.data.repository.CrudRepository;

public interface JobTimeRepository<JobTime, Long> extends CrudRepository<JobTime, Long> {
}
