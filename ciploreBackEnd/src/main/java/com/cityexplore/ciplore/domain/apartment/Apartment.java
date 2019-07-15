package com.cityexplore.ciplore.domain.apartment;

import com.cityexplore.ciplore.domain.LocationEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Apartment extends LocationEntity {

    @NotBlank(message = "Apartment name is required")
    @Column(unique = true)
    private String apartmentName;

    private String apartmentNameId;

    @NotBlank(message = "Apartment Info is required")
    private String apartmentInfo;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "apartment")
    @JsonIgnore
    private ApartmentBacklog apartmentBacklog;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date created_At;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;


    public Apartment() {
    }


    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
        this.apartmentNameId = apartmentName.replaceAll("\\s+","").toUpperCase();
    }

    public String getApartmentNameId() {
        return apartmentNameId;
    }

    public void setApartmentNameId(String apartmentNameId) {
        this.apartmentNameId = apartmentNameId;
    }

    public String getApartmentInfo() {
        return apartmentInfo;
    }

    public void setApartmentInfo(String apartmentInfo) {
        this.apartmentInfo = apartmentInfo;
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


    public ApartmentBacklog getApartmentBacklog() {
        return apartmentBacklog;
    }

    public void setApartmentBacklog(ApartmentBacklog apartmentBacklog) {
        this.apartmentBacklog = apartmentBacklog;
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
