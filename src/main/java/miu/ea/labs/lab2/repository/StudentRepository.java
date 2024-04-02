package miu.ea.labs.lab2.repository;

import miu.ea.labs.lab2.model.Course;
import miu.ea.labs.lab2.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Repository
public class StudentRepository {
    private Map<Long, Student> students = new HashMap<Long, Student>();

    public Student save(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student update(Student student) throws Exception {
        if(!students.containsKey(student.getId())) throw new Exception("Student not found");
        return save(student);
    }

    public void delete(Long id){
        students.remove(id);
    }

    public Student findStudent(Long id) throws Exception {
        if(!students.containsKey(id)) throw new Exception("Student not found");
        return students.get(id);
    }

    public Collection<Student> findAll() {
        return students.values();
    }

    public List<Student> findStudentByMajor(String major){
        return students.values().stream()
                .filter(s -> s.getMajor().equals(major)).toList();
    }

}
