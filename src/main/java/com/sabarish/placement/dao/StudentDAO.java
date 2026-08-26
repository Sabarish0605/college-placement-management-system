package com.sabarish.placement.dao;
import com.sabarish.placement.model.Student;
import java.util.List;
public interface StudentDAO {

    void save(Student student);
    Student findByRegisterNumber(String registerNumber);
    List<Student> findAll();

}
