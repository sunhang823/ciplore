package com.cityexplore.ciplore.domain.apartment;

import com.cityexplore.ciplore.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Apartment extends BaseEntity {

    @NotBlank(message = "Apartment name is required")
    private String apartmentName;

    @NotBlank(message = "Apartment Info is required")
    private String apartmentInfo;

    @NotBlank(message = "Apartment address is required")
    private String apartmentAddress;

    @NotBlank(message = "Apartment city is required")
    private String apartmentCity;

    @NotBlank(message = "Apartment state is required")
    private String apartmentState;

    @NotBlank(message = "Apartment country is required")
    private String apartmentCountry;

    @NotNull(message = "Apartment zipCode is required")
    private Integer apartmentZipCode;

    //url

    //image
    @Lob
    private Byte[] image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apartment")
    private Set<Room> rooms = new HashSet<>();

    @JsonFormat(pattern = "yyy-mm-dd")
    @Column(updatable = false)
    private Date created_At;

    @JsonFormat(pattern = "yyy-mm-dd")
    private Date updated_At;


    public Apartment() {
    }


    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getApartmentInfo() {
        return apartmentInfo;
    }

    public void setApartmentInfo(String apartmentInfo) {
        this.apartmentInfo = apartmentInfo;
    }

    public String getApartmentAddress() {
        return apartmentAddress;
    }

    public void setApartmentAddress(String apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }

    public String getApartmentCity() {
        return apartmentCity;
    }

    public void setApartmentCity(String apartmentCity) {
        this.apartmentCity = apartmentCity;
    }

    public String getApartmentState() {
        return apartmentState;
    }

    public void setApartmentState(String apartmentState) {
        this.apartmentState = apartmentState;
    }

    public String getApartmentCountry() {
        return apartmentCountry;
    }

    public void setApartmentCountry(String apartmentCountry) {
        this.apartmentCountry = apartmentCountry;
    }

    public Integer getApartmentZipCode() {
        return apartmentZipCode;
    }

    public void setApartmentZipCode(Integer apartmentZipCode) {
        this.apartmentZipCode = apartmentZipCode;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }
}
