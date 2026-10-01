package com.sabarish.placement_management_system.service;

import com.sabarish.placement_management_system.Models.Company;
import com.sabarish.placement_management_system.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(String companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    public Company updateCompany(String companyId, Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(String companyId) {
        companyRepository.deleteById(companyId);
    }
}