package com.cityexplore.ciplore.domain.Job;

import com.cityexplore.ciplore.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Job extends BaseEntity {

    private String title;

    private String company;

    private String description;


}
