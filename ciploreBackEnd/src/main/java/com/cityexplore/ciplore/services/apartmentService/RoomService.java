package com.cityexplore.ciplore.services.apartmentService;

import com.cityexplore.ciplore.domain.apartment.Apartment;
import com.cityexplore.ciplore.domain.apartment.Room;
import com.cityexplore.ciplore.exceptions.IdentifierException;
import com.cityexplore.ciplore.repositories.apartmentRepository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ApartmentService apartmentService;

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id){
        Room room = roomRepository.findById(id).orElse(null);

        if(room == null) {
            throw new IdentifierException("Room Id '" + id + "' does not exist");
        }
        return room;
    }

    public Room findRoomByRoomNumber(String apartmentName, Integer roomNumber) {
        Apartment apartment = apartmentService.findApartmentByApartmentName(apartmentName);

        Set<Room> rooms = apartment.getRooms();

        Room room = null;
        for(Room curtRoom : rooms) {
            if(curtRoom.getRoomNumber() == roomNumber) {
                room = curtRoom;
            }
        }
        if(room == null) {
            throw new IdentifierException("Apartment '" + apartmentName + "' does not have Room '" + roomNumber + "'");
        }
        return room;
    }

    public Room updateRoom(Room updatedRoom) {
        findRoomById(updatedRoom.getId());
        return saveRoom(updatedRoom);
    }

    public Iterable<Room> findAllRooms(){
        return  roomRepository.findAll();
    }

    public Iterable<Room> findAllRoomsInThisApartment(String apartmentName) {
        Apartment apartment = apartmentService.findApartmentByApartmentName(apartmentName);

        return apartment.getRooms();
    }

    public void deleteRoomById(Long id){
        Room room = findRoomById(id);

        roomRepository.delete(room);
    }

    public void deleteRoomByRoomNumber(String apartmentName, Integer roomNumber) {
        Room room = findRoomByRoomNumber(apartmentName, roomNumber);
        roomRepository.delete(room);
    }

}
