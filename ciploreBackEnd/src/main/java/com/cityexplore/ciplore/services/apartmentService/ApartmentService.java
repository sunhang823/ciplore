package com.cityexplore.ciplore.services.apartmentService;


import com.cityexplore.ciplore.domain.apartment.Apartment;
import com.cityexplore.ciplore.exceptions.IdentifierException;
import com.cityexplore.ciplore.repositories.apartmentRepository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;

    public Apartment saveApartment(Apartment apartment) {

        return apartmentRepository.save(apartment);

    }

    public Apartment findApartmentById(Long id) {
        Apartment apartment = apartmentRepository.findById(id).orElse(null);

        if(apartment == null) {
            throw new IdentifierException("Apartment Id '" + id + "' does not exist");
        }

        return apartment;
    }

    public Apartment updateApartment(Apartment updatedApartment){
        findApartmentById(updatedApartment.getId());
        return saveApartment(updatedApartment);
    }

    public Iterable<Apartment> findAllApartments(){
        return apartmentRepository.findAll();
    }

    public void deleteApartmentById(Long id) {
        Apartment apartment = apartmentRepository.findById(id).orElse(null);

        if(apartment == null) {
            throw new IdentifierException("Cannot delete apartment with Id " + id + ". This property does not exist.");
        }

        apartmentRepository.delete(apartment);
    }
}
