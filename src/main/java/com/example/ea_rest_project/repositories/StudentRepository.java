package com.example.ea_rest_project.repositories;

import com.example.ea_rest_project.domain.Course;
import com.example.ea_rest_project.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> studentList = new ArrayList<>();



    public void saveStudent(Student student){
        studentList.add(student);
    }

    public List<Student> getAllStudents(){
        return studentList;
    }

    public Student getStudentById(int id){
        return studentList.stream()
                .filter(s -> s.getId() == id)
                .findFirst().get();
    }

    public void updateStudent(Student student){
        for(Student s: studentList){
            if(s.getId() == student.getId()){
                s.setId(student.getId());
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setEmail(student.getEmail());
                s.setMajor(student.getMajor());
                s.setGpa(student.getGpa());
                s.setCoursesTaken(student.getCoursesTaken());
            }
        }
    }

    public void deleteStudent(Student student){
        for(Student s: studentList){
            if(s.getId() == student.getId()){
                studentList.remove(student);
            }
        }
    }

    public List<Student> getStudentsByMajor(String major){
        List<Student> listOfStudentsByMajor = new ArrayList<>();
        for(Student s: studentList){
            if(s.getMajor().equals(major)){
                listOfStudentsByMajor.add(s);
            }
        }
        return listOfStudentsByMajor;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        for (Student s : studentList) {
            if (s.getId() == studentId) {
                return s.getCoursesTaken();
            }
        }
        return null;
    }
}
