package com.cityexplore.ciplore.domain.apartment;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Room {

    private Integer roomNumber;

    private RoomType roomType;

    private Integer price;

    private Date avaliableDate;

    public Room() {
    }

    public Room(Integer roomNumber, RoomType roomType, Integer price, Date avaliableDate) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.avaliableDate = avaliableDate;
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

    public Date getAvaliableDate() {
        return avaliableDate;
    }

    public void setAvaliableDate(Date avaliableDate) {
        this.avaliableDate = avaliableDate;
    }
}
