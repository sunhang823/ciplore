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
}
