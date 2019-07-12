package com.cityexplore.ciplore.repositories;

import com.cityexplore.ciplore.domain.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

}
