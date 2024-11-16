package com.example.StudentManagementSystem.service;
import com.example.StudentManagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
 
public interface StudentService {
    Student saveStudent(Student student); 
    List<Student> getAllStudent();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id); 
    void deleteStudent(long id);
    List<Student> getStudentsByYearOfEnrollment(int year);
    String getDepartmentByStudentId(long id);
    void deleteStudentsByYearOfEnrollment(int year);
}
