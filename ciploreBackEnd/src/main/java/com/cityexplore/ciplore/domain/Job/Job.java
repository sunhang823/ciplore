package com.cityexplore.ciplore.domain.Job;

import com.cityexplore.ciplore.domain.BaseEntity;
import com.cityexplore.ciplore.domain.LocationEntity;
import com.cityexplore.ciplore.domain.apartment.ApartmentBacklog;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Job extends BaseEntity {

    private String title;

    private String description;

    private String jobId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyBacklog_id", updatable = false, nullable = false)
    @JsonIgnore
    private CompanyBacklog companyBacklog;

    public Job() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public CompanyBacklog getCompanyBacklog() {
        return companyBacklog;
    }

    public void setCompanyBacklog(CompanyBacklog companyBacklog) {
        this.companyBacklog = companyBacklog;
    }
}
