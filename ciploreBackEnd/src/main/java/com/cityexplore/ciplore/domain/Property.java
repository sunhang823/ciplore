package com.cityexplore.ciplore.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Property extends BaseEntity{

    @NotBlank(message = "Property name is required")
    private String propertyName;

    @NotBlank(message = "Property Info is required")
    private String propertyInfo;

    @NotBlank(message = "Property adress is required")
    private String propertyAddress;

    @NotBlank(message = "Property city is required")
    private String propertyCity;

    @NotBlank(message = "Property state is required")
    private String propertyState;

    @NotBlank(message = "Property country is required")
    private String propertyCountry;

    @NotNull(message = "Property zipCode is required")
    private Integer propertyZipCode;

    //url

    //image
    @Lob
    private Byte[] image;

    @JsonFormat(pattern = "yyy-mm-dd")
    @Column(updatable = false)
    private Date created_At;

    @JsonFormat(pattern = "yyy-mm-dd")
    private Date updated_At;


    public Property() {
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyCity() {
        return propertyCity;
    }

    public void setPropertyCity(String propertyCity) {
        this.propertyCity = propertyCity;
    }

    public String getPropertyState() {
        return propertyState;
    }

    public void setPropertyState(String propertyState) {
        this.propertyState = propertyState;
    }

    public String getPropertyCountry() {
        return propertyCountry;
    }

    public void setPropertyCountry(String propertyCountry) {
        this.propertyCountry = propertyCountry;
    }

    public Integer getPropertyZipCode() {
        return propertyZipCode;
    }

    public void setPropertyZipCode(Integer propertyZipCode) {
        this.propertyZipCode = propertyZipCode;
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

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }
}
