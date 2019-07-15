package com.cityexplore.ciplore.domain.apartment;

import com.cityexplore.ciplore.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ApartmentBacklog extends BaseEntity {

    private String apartmentNameId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id", nullable = false)
    @JsonIgnore
    private Apartment apartment;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, mappedBy = "apartmentBacklog", orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    public ApartmentBacklog() {
    }

    public String getApartmentNameId() {
        return apartmentNameId;
    }

    public void setApartmentNameId(String apartmentNameId) {
        this.apartmentNameId = apartmentNameId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
