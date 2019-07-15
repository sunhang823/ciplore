package com.cityexplore.ciplore.repositories.apartmentRepository;

import com.cityexplore.ciplore.domain.apartment.ApartmentBacklog;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentBacklogRepository extends CrudRepository<ApartmentBacklog, Long> {

    ApartmentBacklog findByApartmentNameId(String apartmentNameId);

}
