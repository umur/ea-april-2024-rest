package miu.ea.lab2.repository;

import miu.ea.lab2.model.Course;
import miu.ea.lab2.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public void update(Student student) {
        Student updatedStudent = students.stream().filter(s -> s.getId() == student.getId()).findFirst().get();
        if (updatedStudent == null) {
            throw new RuntimeException("Student does not exist");
        }
        updatedStudent.setGpa(student.getGpa());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setMajor(student.getMajor());
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());

    }

    public void delete(Long id) {
        Student deletedStudent = students.stream().filter(s -> s.getId() == id).findFirst().get();
        if (deletedStudent == null) {
            throw new RuntimeException("Student does not exist");
        }
        students.remove(deletedStudent);
    }

    public List<Student> getAll() {
        return this.students;
    }

    public Student getById(Long id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public List<Student> getByMajor(String major) {

        return this.students.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesById(Long id) {
        Student student = getById(id);
        return student.getCoursesTaken();
    }
}
