package com.sabarish.placement.dao;

import com.sabarish.placement.model.Company;
import java.util.List;

public interface CompanyDAO {

    void save(Company company);

    Company findByCompanyId(String companyId);

    List<Company> findAll();
}