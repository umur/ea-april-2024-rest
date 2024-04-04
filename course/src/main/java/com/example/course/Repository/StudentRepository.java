package com.example.course.Repository;

import com.example.course.Domain.Course;
import com.example.course.Domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private List<Student> listStudent= new ArrayList<>();


    public void addStudent(Student student){
        listStudent.add(student);
    }

    public Optional<Student> getStudentById(long id){
        return listStudent.stream()
                .filter(s -> s.getId()==id).findFirst();
    }

    public List<Student> getStudentByMajor(String major) {
        return listStudent.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCourseByStudentId(long id){
      Optional<Student> student = getStudentById(id);
        if (student.isPresent()) {
            return student.get().getCourseTaken();
        } else {
            return new ArrayList<>();
        }
    }

    public void deleteStudent(long id ){
        Optional<Student> student = getStudentById(id);
         student.map(s->listStudent.remove(student));
    }
    public void updateStudent(long id, Student student){
        Optional<Student> studentOld=  getStudentById(id);
        studentOld.ifPresent(oldCourse -> {
            int i = this.listStudent.indexOf(oldCourse);
            this.listStudent.set(i, student);
        });
    }
    public  void addCourseToStudent(long idStudent,Course course){
        Optional<Student> student = getStudentById(idStudent);
        student.ifPresent(s->s.addCourse(course));

    }


}
