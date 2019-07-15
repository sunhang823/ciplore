package com.cityexplore.ciplore.repositories.apartmentRepository;

import com.cityexplore.ciplore.domain.apartment.Apartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {
}
