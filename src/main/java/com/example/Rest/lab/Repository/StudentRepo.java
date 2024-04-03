package com.example.Rest.lab.Repository;

import com.example.Rest.lab.Entity.Course;
import com.example.Rest.lab.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private List<Student> studentList =new ArrayList<>();

    public void addStudent(Student s){
        studentList.add(s);
    }

    public List<Student> getStudents(){
        return studentList;
    }

    public Student getStudentById(long id){
        return studentList.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .get();
    }

    public void updateStudent(Student s, long id){
        Student x = getStudentById(id);
        x.setId(s.getId());
        x.setGpa(s.getGpa());
        x.setEmail(s.getEmail());
        x.setMajor(s.getMajor());
        x.setLastName(s.getLastName());
        x.setFirstName(s.getFirstName());
        x.setCoursesTaken(s.getCoursesTaken());
    }

    public void deleteStudent(long id){
        studentList.removeIf(s->s.getId()==id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentList.stream()
                .filter(s->s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(long id){
        return getStudentById(id).getCoursesTaken();
    }
}
