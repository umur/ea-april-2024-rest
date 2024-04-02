package miu.ea.labs.lab2.service;

import lombok.*;
import miu.ea.labs.lab2.model.Course;
import miu.ea.labs.lab2.model.Student;
import miu.ea.labs.lab2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudentsByMajor(String major){
        return studentRepository.findStudentByMajor(major);
    }

    public List<Course> getCoursesByStudentId(Long studentId) throws Exception{
        return studentRepository.findStudent(studentId).getCoursesTaken();
    }

    public Collection<Student> getStudents(){
        return studentRepository.findAll();
    }
}



