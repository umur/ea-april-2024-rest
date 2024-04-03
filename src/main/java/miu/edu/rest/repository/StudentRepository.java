package miu.edu.rest.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import miu.edu.rest.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Getter
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public Student getStudentById(Long id) {
        return students.stream()
                .filter(s -> s.getStudentId() == id)
                .findFirst()
                .get();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(Long id, Student newStudent) {
        Student student = this.students.stream()
                .filter(s -> s.getStudentId() == id)
                .findFirst()
                .get();

        int index = this.students.indexOf(student);
        this.students.set(index, newStudent);
    }

    public void deleteStudent(Long id) {
        Student student = this.students.stream()
                .filter(s -> s.getStudentId() == id)
                .findFirst()
                .get();

        this.students.remove(student);
    }


    public List<Student> getStudentsByMajor(String major) {
        return this.students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }
}
