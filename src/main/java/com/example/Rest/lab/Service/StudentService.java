package com.example.Rest.lab.Service;

import com.example.Rest.lab.Entity.Course;
import com.example.Rest.lab.Entity.Student;
import com.example.Rest.lab.Repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    public final StudentRepo repo;

    public void addStudent(Student s){
        repo.addStudent(s);
    }

    public List<Student> getAllStudents() {
        return repo.getStudents();
    }

    public Student getStudentById(long id) {
        return repo.getStudentById(id);
    }

    public void updateStudent(Student updatedStudent, long id) {
        repo.updateStudent(updatedStudent, id);
    }

    public void deleteStudent(long id) {
        repo.deleteStudent(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return repo.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(long id) {
        return repo.getCoursesByStudentId(id);
    }
}
