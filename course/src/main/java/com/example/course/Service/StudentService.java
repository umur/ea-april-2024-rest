package com.example.course.Service;

import com.example.course.Domain.Course;
import com.example.course.Domain.Student;
import com.example.course.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentService;

    public StudentService(StudentRepository courseService) {
        this.studentService = courseService;
    }
    public void createStudent(Student student){
        studentService.addStudent(student);
    }

    public Optional<Student> getStudentById(Long id){
       return this.studentService.getStudentById(id);
    }

    public List<Course> getCourseByStudentID(Long id){
        return this.studentService.getCourseByStudentId(id);
    }

    public List<Student> getStudentByMajor(String major){
        return this.studentService.getStudentByMajor(major);
    }

    public  void deleteStudent(long id){
        this.studentService.deleteStudent(id);
    }
    public void  updateStudent(long id,Student student){
        this.studentService.updateStudent(id,student);
    }

    public void addCourse (long id, Course course){
        this.studentService.addCourseToStudent(id,course);
    }
}
