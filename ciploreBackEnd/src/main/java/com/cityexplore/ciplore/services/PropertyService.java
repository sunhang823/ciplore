package com.cityexplore.ciplore.services;

import com.cityexplore.ciplore.domain.Property;
import com.cityexplore.ciplore.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Property saveOrUpdateProperty(Property property) {
        return propertyRepository.save(property);
    }
}
