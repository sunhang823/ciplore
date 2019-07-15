package com.cityexplore.ciplore.services.apartmentService;

import com.cityexplore.ciplore.domain.apartment.ApartmentBacklog;
import com.cityexplore.ciplore.domain.apartment.Room;
import com.cityexplore.ciplore.exceptions.NotFoundException;
import com.cityexplore.ciplore.repositories.apartmentRepository.ApartmentBacklogRepository;
import com.cityexplore.ciplore.repositories.apartmentRepository.ApartmentRepository;
import com.cityexplore.ciplore.repositories.apartmentRepository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private ApartmentBacklogRepository apartmentBacklogRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private ApartmentService apartmentService;

    public Room saveRoom(String apartmentName, Room room) {
        ApartmentBacklog apartmentBacklog = apartmentService.findApartmentByApartmentName(apartmentName).getApartmentBacklog();

        room.setApartmentBacklog(apartmentBacklog);

        String apartmentNameId = apartmentName.replaceAll("\\s+","").toUpperCase();

        room.setRoomId(apartmentNameId + "-" + room.getRoomNumber());
        room.setApartmentNameId(apartmentNameId);

        return roomRepository.save(room);
    }

    public Iterable<Room> findApartmentBacklogByApartmentName(String apartmentName) {
        System.out.println(apartmentName);
        apartmentService.findApartmentByApartmentName(apartmentName);

        String apartmentNameId = apartmentName.replaceAll("\\s+","").toUpperCase();
        return roomRepository.findByApartmentNameId(apartmentNameId);
    }

    public Room findRoomByRoomId(String apartmentName, String roomId) {
        apartmentService.findApartmentByApartmentName(apartmentName);
        Room room = roomRepository.findByRoomId(roomId.toUpperCase());

        if(room == null) {
            throw new NotFoundException("Room Id '" + roomId + "' does not exist in Apartment: " + apartmentName);
        }

        return room;
    }

    public Room updateByRoomNumber(String apartmentName, String roomId, Room updatedRoom) {
        Room room = findRoomByRoomId(apartmentName, roomId);

        room = updatedRoom;

        return roomRepository.save(room);
    }

    public void deleteRoomByRoomNumber(String apartmentName, String roomId) {
        Room room = findRoomByRoomId(apartmentName, roomId);

        roomRepository.delete(room);
    }

}
