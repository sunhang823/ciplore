package com.cityexplore.ciplore.domain.apartment;

import com.cityexplore.ciplore.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Room extends BaseEntity {

    @NotNull(message = "Room number is required")
    private Integer roomNumber;

    @NotBlank(message = "Room Type is Required")
    @ManyToOne
    @JoinColumn(name = "type_id")
    private RoomType roomType;

    private Integer price;

    private Date availableDate;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public Room() {
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
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

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
