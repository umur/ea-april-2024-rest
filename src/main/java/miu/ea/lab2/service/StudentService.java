package miu.ea.lab2.service;

import miu.ea.lab2.entity.Course;
import miu.ea.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    //CRUD of student
    //Add new Student
    Student addStudent(Student student);

    //Get all student
    List<Student> getAllStudents();

    //Get student by id
    Student getStudentById(Long id);

    //Update student
    Student updateStudent(Student student);

    //Delete student
    Student deleteStudent(Long id);

    //    Implement getStudentsByMajor(String major) method.
//    Returns all students majoring major.
    List<Student> getStudentsByMajor(String major);


    List<Course> getCourseByStudentId(Long id);
}
