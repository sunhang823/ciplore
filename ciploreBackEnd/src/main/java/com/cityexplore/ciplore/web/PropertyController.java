package com.cityexplore.ciplore.web;

import com.cityexplore.ciplore.domain.Property;
import com.cityexplore.ciplore.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("")
    public ResponseEntity<?> createNewProperty(@Valid @RequestBody Property property, BindingResult result) {

        if(result.hasErrors()){
            Map<String, String > errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Property property1 = propertyService.saveOrUpdateProperty(property);
        return new ResponseEntity<Property>(property1, HttpStatus.CREATED);
    }
}
