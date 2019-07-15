package com.cityexplore.ciplore.web.apartmentController;

import com.cityexplore.ciplore.domain.apartment.Room;
import com.cityexplore.ciplore.services.MapValidationErrorService;
import com.cityexplore.ciplore.services.apartmentService.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/apartmentbacklog")
public class ApartmentBacklogController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/{apartmentName}")
    public ResponseEntity<?> createNewRoom(@Valid @RequestBody Room room, BindingResult result, @PathVariable String apartmentName) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Room room1 = roomService.saveRoom(apartmentName, room);
        return new ResponseEntity<Room>(room1, HttpStatus.CREATED);
    }

    @GetMapping("/{apartmentName}")
    public Iterable<Room> getApartmentBacklog(@PathVariable String apartmentName) {

        return roomService.findApartmentBacklogByApartmentName(apartmentName);
    }
}
