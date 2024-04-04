package com.example.ea_rest_project.services;

import com.example.ea_rest_project.domain.Course;
import com.example.ea_rest_project.domain.Student;
import com.example.ea_rest_project.dto.StudentRequest;
import com.example.ea_rest_project.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        if (student != null) {
            studentRepository.saveStudent(student);
        }
        throw new NullPointerException("Student is null");
    }


    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int id){
        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Integer id, StudentRequest studentRequest){
        Student student = studentRepository.getStudentById(id);
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setMajor(studentRequest.getMajor());
        student.setGpa(studentRequest.getGpa());
        student.setCoursesTaken(studentRequest.getCoursesTaken());

        studentRepository.saveStudent(student);
    }

    public void deleteStudent(Integer id){
        for(Student s: studentRepository.getStudentList()){
            if(s.getId().equals(id)){
                studentRepository.deleteStudent(s);
                return;
            }
        }
        throw new NullPointerException("Student is null");
    }

    public List<Student> getStudentsByMajor(String major){
        List<Student> listOfStudentsByMajor = new ArrayList<>();
        for(Student s: studentRepository.getStudentList()){
            if(s.getMajor().equals(major)){
                listOfStudentsByMajor.add(s);
            }
        }
        return listOfStudentsByMajor;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        for (Student s : studentRepository.getStudentList()) {
            if (s.getId() == studentId) {
                return s.getCoursesTaken();
            }
        }
        return null;
    }
}
