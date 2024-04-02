package com.sonny.ea.rest.interfaces;

import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudentsByMajor(String major);
    public List<Course> getCoursesByStudentId(int studentId);

    public void addCourse(int studentId, int courseId);
    public Student getStudentById(int studentId);
    public void addStudent(Student student);
    public void updateStudent(int studentId, Student student);
    public Student deleteStudent(int studentId);
    public List<Student> getAllStudents();
}
