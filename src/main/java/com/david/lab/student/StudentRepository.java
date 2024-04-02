package com.david.lab.student;

import com.david.lab.course.Course;
import com.david.lab.course.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    private static final List<Student> STUDENTS = new ArrayList<>();
    private static long LAST_USED_ID = 0;

    public StudentRepository(CourseRepository courseRepository) {
        List<Course> allCourses = courseRepository.getAllCourses();
        STUDENTS.addAll(Arrays.asList(
                new Student(++LAST_USED_ID, "David", "Davaatulga", "e.davaatulga@miu.edu", "Computer Science", "3.5", List.of(allCourses.get(0), allCourses.get(1))),
                new Student(++LAST_USED_ID, "Jane", "Doe", "jane.doe@miu.edu", "Software Engineering", "3.8", List.of(allCourses.get(3), allCourses.get(4)))
        ));
    }

    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    public Optional<Student> getStudentById(long id) {
        return STUDENTS.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public Student addStudent(Student student) {
        student.setId(++LAST_USED_ID);
        STUDENTS.add(student);
        return student;
    }

    public Optional<Student> updateStudent(Student studentToUpdate) {
        return STUDENTS.stream()
                .filter(student -> student.getId() == studentToUpdate.getId())
                .map(student -> studentToUpdate)
                .findAny();
    }

    public void deleteStudent(long id) {
        STUDENTS.removeIf(student -> student.getId() == id);
    }
}