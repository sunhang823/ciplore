package com.cityexplore.ciplore.domain.apartment;

import com.cityexplore.ciplore.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
public class RoomType extends BaseEntity {

    private String RoomTypeName;

    private Integer numOfBedroom;

    private Integer numOfBathroom;

    public RoomType() {
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        RoomTypeName = roomTypeName;
    }

    public Integer getNumOfBedroom() {
        return numOfBedroom;
    }

    public void setNumOfBedroom(Integer numOfBedroom) {
        this.numOfBedroom = numOfBedroom;
    }

    public Integer getNumOfBathroom() {
        return numOfBathroom;
    }

    public void setNumOfBathroom(Integer numOfBathroom) {
        this.numOfBathroom = numOfBathroom;
    }
}
