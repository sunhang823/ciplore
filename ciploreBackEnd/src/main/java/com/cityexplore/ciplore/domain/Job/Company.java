package com.cityexplore.ciplore.domain.Job;

import com.cityexplore.ciplore.domain.LocationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Company extends LocationEntity {

    private String companyName;

    private String description;

    private String companyNameId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "company")
    @JsonIgnore
    private CompanyBacklog companyBacklog;

    public Company() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyNameId() {
        return companyNameId;
    }

    public void setCompanyNameId(String companyNameId) {
        this.companyNameId = companyNameId;
    }

    public CompanyBacklog getCompanyBacklog() {
        return companyBacklog;
    }

    public void setCompanyBacklog(CompanyBacklog companyBacklog) {
        this.companyBacklog = companyBacklog;
    }
}
