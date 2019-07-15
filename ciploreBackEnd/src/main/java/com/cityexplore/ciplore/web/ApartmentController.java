package com.cityexplore.ciplore.web;

import com.cityexplore.ciplore.domain.apartment.Apartment;
import com.cityexplore.ciplore.services.apartmentService.ApartmentService;
import com.cityexplore.ciplore.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/apartment")
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewApartment(@Valid @RequestBody Apartment apartment, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Apartment apartment1 = apartmentService.saveApartment(apartment);
        return new ResponseEntity<Apartment>(apartment1, HttpStatus.CREATED);
    }


    @PatchMapping("update")
    public ResponseEntity<?> updateApartment(@Valid @RequestBody Apartment apartment, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Apartment apartment1 = apartmentService.updateApartment(apartment);
        return new ResponseEntity<Apartment>(apartment1, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getApartmentById(@PathVariable Long id){
        Apartment apartment= apartmentService.findApartmentById(id);

        return new ResponseEntity<Apartment>(apartment, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Apartment> getAllApartments() {
        return apartmentService.findAllApartments();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartmentById(id);
        return new ResponseEntity<String>("Apartment with ID :" + id + " was deleted", HttpStatus.OK);
    }
}
