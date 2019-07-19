package com.cityexplore.ciplore.domain.Job;

import com.cityexplore.ciplore.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CompanyBacklog extends BaseEntity {

    private String companyNameId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    private Company company;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, mappedBy = "companyBacklog", orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();

    public CompanyBacklog() {
    }

    public String getCompanyNameId() {
        return companyNameId;
    }

    public void setCompanyNameId(String companyNameId) {
        this.companyNameId = companyNameId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
