package com.cityexplore.ciplore.web.apartmentController;

import com.cityexplore.ciplore.domain.apartment.Room;
import com.cityexplore.ciplore.services.MapValidationErrorService;
import com.cityexplore.ciplore.services.apartmentService.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewRoom(@Valid @RequestBody Room room, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Room room1 = roomService.saveRoom(room);
        return new ResponseEntity<Room>(room1, HttpStatus.CREATED);
    }
}
