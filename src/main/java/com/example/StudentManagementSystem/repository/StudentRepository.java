package com.example.StudentManagementSystem.repository;
import com.example.StudentManagementSystem.model.Student; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    //crud
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);
    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentByStudentId(@Param("id") long id);
    @Modifying
    @Query("DELETE FROM Student s WHERE s.yearOfEnrollment = :year")
    void deleteByYearOfEnrollment(@Param("year") int year);

}
