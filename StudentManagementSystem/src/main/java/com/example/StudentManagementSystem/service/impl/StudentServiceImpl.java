package com.example.StudentManagementSystem.service.impl;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository; 
import com.example.StudentManagementSystem.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; 
import java.util.Optional; 
  
@Service 
public class StudentServiceImpl implements StudentService {
    
    @Autowired 
    private StudentRepository studentRepository;
    //save student in database 
    @Override 
    public Student saveStudent(Student student){
        return studentRepository.save(student); 
    } 
    //get all student form database
    @Override public List<Student> getAllStudent() {
        return studentRepository.findAll();
    } 
    //get student using id 
    @Override public Student getStudentById(long id) {
        Optional<Student> Student = studentRepository.findById(id); 
        if(Student.isPresent()){ 
            return Student.get(); 
        }else {
            throw new RuntimeException(); 
        } 
    } 
    //update student 
    @Override 
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow( ()-> new RuntimeException() ); 
        existingStudent.setFirstName(student.getFirstName()); 
        existingStudent.setLastName(student.getLastName()); 
        existingStudent.setEmail(student.getEmail()); 
        // save 
        studentRepository.save(existingStudent); 
        return existingStudent; 
    }
    //delete student 
    @Override 
    public void deleteStudent(long id) {
        //check
        studentRepository.findById(id).orElseThrow(()-> new RuntimeException()); 
        //delete 
        studentRepository.deleteById(id); 
    }
    public List<Student> getStudentsByYearOfEnrollment(int year) {
        return studentRepository.findByYearOfEnrollment(year);
    }
    public String getDepartmentByStudentId(long id) {
        return studentRepository.findDepartmentByStudentId(id);
    }
    @Transactional
    public void deleteStudentsByYearOfEnrollment(int year) {
        studentRepository.deleteByYearOfEnrollment(year);
    }

}
 