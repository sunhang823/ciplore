package com.cityexplore.ciplore.web;

import com.cityexplore.ciplore.domain.Property;
import com.cityexplore.ciplore.services.MapValidationErrorService;
import com.cityexplore.ciplore.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProperty(@Valid @RequestBody Property property, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Property property1 = propertyService.saveProperty(property);
        return new ResponseEntity<Property>(property1, HttpStatus.CREATED);
    }


    @PatchMapping("update")
    public ResponseEntity<?> updateProperty(@Valid @RequestBody Property property, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Property property1 = propertyService.updateProperty(property);
        return new ResponseEntity<Property>(property1, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPropertyByIdentifier(@PathVariable Long id){
        Property property = propertyService.findByPropertyId(id);

        return new ResponseEntity<Property>(property, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Property> getAllProperties() {
        return propertyService.findAllProperties();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        propertyService.deletePropertyById(id);
        return new ResponseEntity<String>("Property with ID :" + id + " was deleted", HttpStatus.OK);
    }

}
