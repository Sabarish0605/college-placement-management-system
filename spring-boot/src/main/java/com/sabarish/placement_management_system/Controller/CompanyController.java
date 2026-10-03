package com.sabarish.placement_management_system.Controller;

import com.sabarish.placement_management_system.Models.Company;
import com.sabarish.placement_management_system.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    ResponseEntity<Company> createCompany(
            @RequestBody Company company) {

        Company savedCompany = companyService.createCompany(company);

        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Company>> getAllCompanies() {

        List<Company> companies = companyService.getAllCompanies();

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    ResponseEntity<Company> getCompanyById(
            @PathVariable String companyId) {

        Company company = companyService.getCompanyById(companyId);

        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/{companyId}")
    ResponseEntity<Company> updateCompany(
            @PathVariable String companyId,
            @RequestBody Company company) {

        Company updatedCompany =
                companyService.updateCompany(companyId, company);

        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }

    @DeleteMapping("/{companyId}")
    ResponseEntity<String> deleteCompany(
            @PathVariable String companyId) {

        companyService.deleteCompany(companyId);

        return new ResponseEntity<>(
                "Company deleted successfully",
                HttpStatus.OK
        );
    }
}