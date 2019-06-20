package com.cityexplore.ciplore.web;

import com.cityexplore.ciplore.domain.Property;
import com.cityexplore.ciplore.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("")
    public ResponseEntity<Property> createNewProperty(@RequestBody Property property) {

        Property property1 = propertyService.saveOrUpdateProperty(property);
        return new ResponseEntity<Property>(property1, HttpStatus.CREATED);
    }
}
