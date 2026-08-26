package com.sabarish.placement.dao;

import com.sabarish.placement.model.Company;
import com.sabarish.placement.model.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAOImpl implements JobDAO {

    private Connection con;

    public JobDAOImpl() {
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
    public void save(Job job) {

        String sql = "INSERT INTO job " +
                "(job_id, role, description, minimum_cgpa, maximum_backlogs, company_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, job.getJobId());
            ps.setString(2, job.getRole());
            ps.setString(3, job.getDescription());
            ps.setDouble(4, job.getMinimumCgpa());
            ps.setInt(5, job.getMaximumBacklogs());
            ps.setString(6, job.getCompany().getCompanyId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Job findByJobId(String jobId) {

        String sql = """
                SELECT j.job_id, j.role, j.description,
                       j.minimum_cgpa, j.maximum_backlogs,
                       c.company_id, c.name, c.email,
                       c.industry, c.location
                FROM job j
                JOIN company c ON j.company_id = c.company_id
                WHERE j.job_id = ?
                """;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, jobId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Company company = new Company(
                        rs.getString("company_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("industry"),
                        rs.getString("location")
                );

                return new Job(
                        rs.getString("job_id"),
                        rs.getString("role"),
                        rs.getString("description"),
                        rs.getDouble("minimum_cgpa"),
                        rs.getInt("maximum_backlogs"),
                        company
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Job> findAll() {

        List<Job> jobs = new ArrayList<>();

        String sql = """
                SELECT j.job_id, j.role, j.description,
                       j.minimum_cgpa, j.maximum_backlogs,
                       c.company_id, c.name, c.email,
                       c.industry, c.location
                FROM job j
                JOIN company c ON j.company_id = c.company_id
                """;

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

                Job job = new Job(
                        rs.getString("job_id"),
                        rs.getString("role"),
                        rs.getString("description"),
                        rs.getDouble("minimum_cgpa"),
                        rs.getInt("maximum_backlogs"),
                        company
                );

                jobs.add(job);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jobs;
    }
}