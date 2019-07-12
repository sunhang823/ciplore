package com.cityexplore.ciplore.services;

import com.cityexplore.ciplore.domain.Property;
import com.cityexplore.ciplore.exceptions.IdentifierException;
import com.cityexplore.ciplore.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Property saveProperty(Property property) {

        return propertyRepository.save(property);

    }

    public Property findByPropertyId(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);

        if(property == null) {
            throw new IdentifierException("Property Id '" + id + "' does not exist");
        }

        return property;
    }

    public Property updateProperty(Property updatedProperty){
        System.out.println(updatedProperty.getId());
        findByPropertyId(updatedProperty.getId());
        return saveProperty(updatedProperty);
    }

    public Iterable<Property> findAllProperties(){
        return propertyRepository.findAll();
    }

    public void deletePropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);

        if(property == null) {
            throw new IdentifierException("Cannot delete property with Id " + id + ". This property does not exist.");
        }

        propertyRepository.delete(property);
    }
}
