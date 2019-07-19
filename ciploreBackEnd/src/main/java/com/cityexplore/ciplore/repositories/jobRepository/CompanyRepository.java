package com.cityexplore.ciplore.repositories.jobRepository;

import com.cityexplore.ciplore.domain.Job.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
