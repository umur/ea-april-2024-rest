package edu.miu.rest.Repository;

import edu.miu.rest.Entity.Course;
import edu.miu.rest.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void updateStudent(long id, Student student) {
        students.stream()
                .filter(std -> std.getId() == id)
                .forEach(filStd -> {
                    filStd.setId(student.getId());
                    filStd.setFirstName(student.getFirstName());
                    filStd.setLastName(student.getLastName());
                    filStd.setEmail(student.getEmail());
                    filStd.setMajor(student.getMajor());
                    filStd.setGpa(student.getGpa());
                    filStd.setCoursesTaken(student.getCoursesTaken());

                });
    }

    public void deleteStudent(long id) {
        students.removeIf(std -> std.getId() == id);
    }

    public List<Student> getStudentByMajor(String major) {
        return students.stream()
                .filter(std -> std.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(long id){
       return students.stream()
                .filter(std -> std.getId() == id)
                .map(Student::getCoursesTaken)
                .flatMap(List::stream)
                .collect(Collectors.toList());

    }
}
