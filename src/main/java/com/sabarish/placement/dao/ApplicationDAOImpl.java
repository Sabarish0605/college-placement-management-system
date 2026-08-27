package com.sabarish.placement.dao;

import com.sabarish.placement.model.Application;
import com.sabarish.placement.model.Company;
import com.sabarish.placement.model.Job;
import com.sabarish.placement.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationDAOImpl implements ApplicationDAO {

    private Connection con;

    public ApplicationDAOImpl() {

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


    // ==================== SAVE ====================

    @Override
    public void save(Application application) {

        String sql = "INSERT INTO application " +
                "(application_id, register_number, job_id, status) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, application.getApplicationId());
            ps.setString(2, application.getStudent().getRegisterNumber());
            ps.setString(3, application.getJob().getJobId());
            ps.setString(4, application.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // ==================== FIND BY ID ====================

    @Override
    public Application findByApplicationId(String applicationId) {

        String sql = """
                SELECT a.application_id,
                       a.register_number,
                       a.job_id,
                       a.status,

                       s.name,
                       s.email,
                       s.contact_number,
                       s.gender,
                       s.department,
                       s.cgpa,
                       s.backlogs,
                       s.skills,
                       s.graduation_year,

                       j.role,
                       j.description,
                       j.minimum_cgpa,
                       j.maximum_backlogs,

                       c.company_id,
                       c.name AS company_name,
                       c.email AS company_email,
                       c.industry,
                       c.location

                FROM application a

                JOIN student s
                    ON a.register_number = s.register_number

                JOIN job j
                    ON a.job_id = j.job_id

                JOIN company c
                    ON j.company_id = c.company_id

                WHERE a.application_id = ?
                """;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, applicationId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapApplication(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    // ==================== FIND ALL ====================

    @Override
    public List<Application> findAll() {

        List<Application> applications = new ArrayList<>();

        String sql = """
                SELECT a.application_id,
                       a.register_number,
                       a.job_id,
                       a.status,

                       s.name,
                       s.email,
                       s.contact_number,
                       s.gender,
                       s.department,
                       s.cgpa,
                       s.backlogs,
                       s.skills,
                       s.graduation_year,

                       j.role,
                       j.description,
                       j.minimum_cgpa,
                       j.maximum_backlogs,

                       c.company_id,
                       c.name AS company_name,
                       c.email AS company_email,
                       c.industry,
                       c.location

                FROM application a

                JOIN student s
                    ON a.register_number = s.register_number

                JOIN job j
                    ON a.job_id = j.job_id

                JOIN company c
                    ON j.company_id = c.company_id
                """;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                applications.add(mapApplication(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return applications;
    }


    // ==================== FIND BY STUDENT ====================

    @Override
    public List<Application> findByStudentRegisterNumber(String registerNumber) {

        List<Application> applications = new ArrayList<>();

        String sql = """
                SELECT a.application_id,
                       a.register_number,
                       a.job_id,
                       a.status,

                       s.name,
                       s.email,
                       s.contact_number,
                       s.gender,
                       s.department,
                       s.cgpa,
                       s.backlogs,
                       s.skills,
                       s.graduation_year,

                       j.role,
                       j.description,
                       j.minimum_cgpa,
                       j.maximum_backlogs,

                       c.company_id,
                       c.name AS company_name,
                       c.email AS company_email,
                       c.industry,
                       c.location

                FROM application a

                JOIN student s
                    ON a.register_number = s.register_number

                JOIN job j
                    ON a.job_id = j.job_id

                JOIN company c
                    ON j.company_id = c.company_id

                WHERE a.register_number = ?
                """;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, registerNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                applications.add(mapApplication(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return applications;
    }


    // ==================== RESULTSET → APPLICATION ====================

    private Application mapApplication(ResultSet rs) throws SQLException {

        List<String> skills =
                Arrays.asList(rs.getString("skills").split(","));

        Student student = new Student(
                rs.getString("register_number"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("contact_number"),
                rs.getString("gender"),
                rs.getString("department"),
                rs.getDouble("cgpa"),
                rs.getInt("backlogs"),
                skills,
                rs.getInt("graduation_year")
        );


        Company company = new Company(
                rs.getString("company_id"),
                rs.getString("company_name"),
                rs.getString("company_email"),
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


        return new Application(
                rs.getString("application_id"),
                student,
                job,
                rs.getString("status")
        );
    }
}