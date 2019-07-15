package com.cityexplore.ciplore.repositories.apartmentRepository;

import com.cityexplore.ciplore.domain.apartment.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Room findByRoomNumber(Integer roomNumber);

    void deleteByRoomNumber(Integer roomNumber);
}
