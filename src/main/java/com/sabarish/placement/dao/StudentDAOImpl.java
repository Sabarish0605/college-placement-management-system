package com.sabarish.placement.dao;

import com.sabarish.placement.model.Student;
import java.sql.*;
import java.util.*;
public class StudentDAOImpl implements StudentDAO {


     Connection con;

    public StudentDAOImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/placement_management";            String username = "root";
            String password = "Sabarish@2006";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO student " +
                "(register_number, name, email, contact_number, gender, department, cgpa, backlogs, skills, graduation_year) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getRegisterNumber());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getContactNumber());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getDepartment());
            ps.setDouble(7, student.getCgpa());
            ps.setInt(8, student.getBacklogs());
            ps.setString(9, student.getSkills().toString());
            ps.setInt(10, student.getGraduationYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student findByRegisterNumber(String registerNumber) {

        String sql = "SELECT * FROM student WHERE register_number = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, registerNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Student student = new Student(
                        rs.getString("register_number"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contact_number"),
                        rs.getString("gender"),
                        rs.getString("department"),
                        rs.getDouble("cgpa"),
                        rs.getInt("backlogs"),
                        List.of(rs.getString("skills")),
                        rs.getInt("graduation_year")
                );

                return student;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Student> findAll() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student student = new Student(
                        rs.getString("register_number"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contact_number"),
                        rs.getString("gender"),
                        rs.getString("department"),
                        rs.getDouble("cgpa"),
                        rs.getInt("backlogs"),
                        List.of(rs.getString("skills")),
                        rs.getInt("graduation_year")
                );

                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}
