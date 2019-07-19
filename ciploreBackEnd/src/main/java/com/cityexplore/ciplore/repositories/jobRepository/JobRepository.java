package com.cityexplore.ciplore.repositories.jobRepository;

import com.cityexplore.ciplore.domain.Job.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}
