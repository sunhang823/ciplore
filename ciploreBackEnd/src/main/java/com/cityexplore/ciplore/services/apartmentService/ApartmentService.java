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
        try{
            return apartmentRepository.save(apartment);
        } catch (Exception e) {
            throw new IdentifierException("Apartment name '" + apartment.getApartmentName() + "' already exists");
        }
    }

    public Apartment findApartmentById(Long id) {
        Apartment apartment = apartmentRepository.findById(id).orElse(null);

        if(apartment == null) {
            throw new IdentifierException("Apartment Id '" + id + "' does not exist");
        }

        return apartment;
    }

    public Apartment findApartmentByApartmentName(String apartmentName) {

        String apartmentNameId = apartmentName.replaceAll("\\s+","").toUpperCase();

        Apartment apartment = apartmentRepository.findByApartmentNameId(apartmentNameId);

        if(apartment == null) {
            throw new IdentifierException("Apartment name '" + apartmentName + "' does not exist");
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
        Apartment apartment = findApartmentById(id);
        apartmentRepository.delete(apartment);
    }
}
