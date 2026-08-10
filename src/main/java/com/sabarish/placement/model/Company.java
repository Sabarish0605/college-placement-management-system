package com.sabarish.placement.model;

public class Company {

    private String companyId;
    private String name;
    private String email;
    private String industry;
    private String location;

    public Company(String companyId, String name, String email,
                   String industry, String location) {

        this.companyId = companyId;
        this.name = name;
        this.email = email;
        this.industry = industry;
        this.location = location;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIndustry() {
        return industry;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", industry='" + industry + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}