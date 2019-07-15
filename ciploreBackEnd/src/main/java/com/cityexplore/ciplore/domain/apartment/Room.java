package com.cityexplore.ciplore.domain.apartment;

import com.cityexplore.ciplore.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Room extends BaseEntity {

    @NotNull(message = "Room number is required")
    private Integer roomNumber;

    private String roomId;

    private String roomType;

    private Integer price;

    private Date availableDate;

    private String apartmentNameId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartmentBacklog_id", updatable = false, nullable = false)
    @JsonIgnore
    private ApartmentBacklog apartmentBacklog;

    public Room() {
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {

        this.roomType = roomType.toUpperCase();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public String getApartmentNameId() {
        return apartmentNameId;
    }

    public void setApartmentNameId(String apartmentNameId) {
        this.apartmentNameId = apartmentNameId;
    }

    public ApartmentBacklog getApartmentBacklog() {
        return apartmentBacklog;
    }

    public void setApartmentBacklog(ApartmentBacklog apartmentBacklog) {
        this.apartmentBacklog = apartmentBacklog;
    }
}
