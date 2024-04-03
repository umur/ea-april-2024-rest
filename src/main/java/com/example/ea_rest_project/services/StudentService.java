package com.example.ea_rest_project.services;

import com.example.ea_rest_project.domain.Course;
import com.example.ea_rest_project.domain.Student;
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

    public void updateStudent(Student student){
        if(student != null){
            studentRepository.updateStudent(student);
        }
        throw new NullPointerException("Student is null");
    }

    public void deleteStudent(Student student){
        if(student != null){
            for(Student s: studentRepository.getStudentList()){
                if(s.getId() == student.getId()){
                    studentRepository.deleteStudent(student);
                }
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
