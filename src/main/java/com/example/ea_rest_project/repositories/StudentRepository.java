package com.example.ea_rest_project.repositories;

import com.example.ea_rest_project.domain.Course;
import com.example.ea_rest_project.domain.Student;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();
    private int id;


    public void saveStudent(Student student) {
        if (student.getId() == null) {
            student.setId(++id);
            studentList.add(student);
            return;
        }
        for(Student s: studentList){
            if(s.getId().equals(student.getId())){
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setEmail(student.getEmail());
                s.setMajor(student.getMajor());
                s.setGpa(student.getGpa());
                s.setCoursesTaken(student.getCoursesTaken());
                return;
            }
        }
    }



        public List<Student> getAllStudents () {
            return studentList;
        }

        public Student getStudentById ( int id){
            return studentList.stream()
                    .filter(s -> s.getId() == id)
                    .findFirst().get();
        }


        public void deleteStudent (Student student){
            studentList.remove(student);
        }

//        public void updateStudent (Student student){
//            for (Student s : studentList) {
//                if (s.getId() == student.getId()) {
//                    s.setId(student.getId());
//                    s.setFirstName(student.getFirstName());
//                    s.setLastName(student.getLastName());
//                    s.setEmail(student.getEmail());
//                    s.setMajor(student.getMajor());
//                    s.setGpa(student.getGpa());
//                    s.setCoursesTaken(student.getCoursesTaken());
//                }
//            }
//        }


    }

