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

    public Property saveOrUpdateProperty(Property property) {

        try {
            property.setPropertyIdentifier(property.getPropertyIdentifier().toUpperCase());
            return propertyRepository.save(property);
        } catch (Exception ex) {
            throw new IdentifierException("Property ID '" + property.getPropertyIdentifier().toUpperCase() + "' already exists");
        }
    }

    public Property findByPropertyIdentifier(String propertiIdentifier) {
        Property property = propertyRepository.findByPropertyIdentifier(propertiIdentifier.toUpperCase());

        if(property == null) {
            throw new IdentifierException("Property Id '" + propertiIdentifier + "' does not exist");
        }

        return property;
    }

    public Iterable<Property> findAllProperties(){
        return propertyRepository.findAll();
    }

    public void deletePropertyByIdentifier(String propertyIdentifier) {
        Property property = propertyRepository.findByPropertyIdentifier(propertyIdentifier.toUpperCase());

        if(property == null) {
            throw new IdentifierException("Cannot delete property with Id " + propertyIdentifier + ". This property does not exist.");
        }

        propertyRepository.delete(property);
    }
}
