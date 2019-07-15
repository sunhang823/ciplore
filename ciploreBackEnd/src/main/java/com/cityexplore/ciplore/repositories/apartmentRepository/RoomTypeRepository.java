package com.cityexplore.ciplore.repositories.apartmentRepository;

import com.cityexplore.ciplore.domain.apartment.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends CrudRepository<RoomType, Long> {
}
