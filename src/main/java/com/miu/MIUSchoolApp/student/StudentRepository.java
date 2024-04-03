package com.miu.MIUSchoolApp.student;

import com.miu.MIUSchoolApp.course.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> listStudent = new ArrayList<>();

    public int getMaxId() {
        return this.listStudent.stream().mapToInt(s -> s.getId()).max().orElse(0) + 1;
    }

    public List<Student> getStudentsByMajor(String major) {
        return listStudent.stream().filter(s -> s.getMajor().equalsIgnoreCase(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return listStudent.stream()
                .filter(c->c.getId() == studentId)
                .findFirst()
                .map(Student::getCoursesTaken)
                .orElse(Collections.emptyList());
    }

    public List<Student> getStudents() {
        return this.listStudent;
    }

    public void addStudent(Student student) {

        int maxId = this.getMaxId();
        student.setId(maxId);
        listStudent.add(student);
    }

    public void updateStudent(Student student) {

        for (Student obj : listStudent) {
            if(obj.getId() == student.getId()) {
                obj.setFirstname(student.getFirstname());
                obj.setLastname(student.getLastname());
                obj.setEmail(student.getEmail());
                obj.setMajor(student.getMajor());
                obj.setGpa(student.getGpa());
                obj.setCoursesTaken(student.getCoursesTaken());
            }
        }
    }

    public long getStudentsByCourse(Course course) {

        long count = listStudent.stream()
                .filter(student -> student.getCoursesTaken().stream()
                        .anyMatch(c -> c.getId()  == course.getId()))
                .count();

        return count;
    }

    public void deleteStudent(Student student) {
        for (Student obj : listStudent) {
            if (obj.getId() == student.getId()) {
                listStudent.remove(obj);
                break;
            }
        }
    }
}
