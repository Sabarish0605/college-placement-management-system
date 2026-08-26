package com.sabarish.placement.dao;

import com.sabarish.placement.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {

    Connection con;

    public CompanyDAOImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/placement_management";
            String username = "root";
            String password = "Sabarish@2006";

            con = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Company company) {

        String sql = "INSERT INTO company " +
                "(company_id, name, email, industry, location) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, company.getCompanyId());
            ps.setString(2, company.getName());
            ps.setString(3, company.getEmail());
            ps.setString(4, company.getIndustry());
            ps.setString(5, company.getLocation());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Company findByCompanyId(String companyId) {

        String sql = "SELECT * FROM company WHERE company_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, companyId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Company company = new Company(
                        rs.getString("company_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("industry"),
                        rs.getString("location")
                );

                return company;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Company> findAll() {

        List<Company> companies = new ArrayList<>();

        String sql = "SELECT * FROM company";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Company company = new Company(
                        rs.getString("company_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("industry"),
                        rs.getString("location")
                );

                companies.add(company);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return companies;
    }
}