package com.brianmugalu.labTwo.service;

import com.brianmugalu.labTwo.repository.StudentRepository;
import com.brianmugalu.labTwo.repository.models.Course;
import com.brianmugalu.labTwo.repository.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.addStudent(student);
        return "Student added Successfully";
    }

    public String removeStudent(int id){
        studentRepository.removeStudent(id);
        return "Student removed Successfully";
    }
    public List<Student> getStudentsByMajor(String major){
        return studentRepository.getStudentsByMajor(major);
    }
    public List<Course> getCoursesByStudentId(int studentId){

        return studentRepository.getCoursesByStudentId(studentId);
    }

    public String addCourses(int id, List<Course> courses) {
        studentRepository.addCourses(id, courses);
        return "Courses successfully Added";
    }
}
