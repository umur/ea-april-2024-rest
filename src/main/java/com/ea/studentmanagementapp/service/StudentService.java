package com.ea.studentmanagementapp.service;

import com.ea.studentmanagementapp.entity.Course;
import com.ea.studentmanagementapp.entity.Student;
import com.ea.studentmanagementapp.pojo.request.StudentRequest;
import com.ea.studentmanagementapp.repository.CourseRepository;
import com.ea.studentmanagementapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Student createStudent(StudentRequest request) {
        Student student = new Student();
        return updateStudentData(request, student);
    }



    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }



    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findByMajor(major);
    }


    public List<Course> getCoursesByStudentId(Long id) {
        return getStudentById(id).getCoursesTaken();
    }



    public Student updateStudent(Long id, StudentRequest request) {
        Student student = getStudentById(id);
        return updateStudentData(request, student);
    }



    private Student updateStudentData(StudentRequest request, Student student) {
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setMajor(request.getMajor());
        student.setGpa(request.getGpa());
        student.setCoursesTaken(courseRepository.findAllById(request.getIdsOfCoursesTaken()));
        return studentRepository.save(student);
    }



    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
