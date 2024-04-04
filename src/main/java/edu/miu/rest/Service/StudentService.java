package edu.miu.rest.Service;

import java.util.List;

import edu.miu.rest.Entity.Student;
import edu.miu.rest.Repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import edu.miu.rest.Entity.Course;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepo studentRepo;

    public void addStudent(Student student) {
        studentRepo.addStudent(student);
    }

    public List<Student> getStudents() {
        return studentRepo.getStudents();
    }

    public Student getStudent(long id){
        return studentRepo.getStudent(id);
    }

    public void updateStudents(long id, Student student){
        studentRepo.updateStudent(id, student);

    }

    public void deleteStudent(long id){
        studentRepo.deleteStudent(id);
    }

    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentByMajor(major);
    }

    public List<Course> getCoursesByStudentId(long id){
        return  studentRepo.getCoursesByStudentId(id);
    }
}
