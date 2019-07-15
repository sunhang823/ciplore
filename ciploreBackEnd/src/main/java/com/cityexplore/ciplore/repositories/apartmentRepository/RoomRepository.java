package com.cityexplore.ciplore.repositories.apartmentRepository;

import com.cityexplore.ciplore.domain.apartment.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findByApartmentNameId(String apartmentNameId);

    Room findByRoomId(String roomId);

}
