package com.ea.studentmanagementapp.repository;

import com.ea.studentmanagementapp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {

    private static final AtomicLong STUDENT_ID_COUNTER = new AtomicLong();
    private static final Set<Student> STUDENT_DATABASE = new HashSet<>();



    public Student save(Student student) {

        if (student.getId() == null) {
            student.setId(STUDENT_ID_COUNTER.incrementAndGet());
        }

        STUDENT_DATABASE.add(student);
        return student;
    }



    public List<Student> findAll() {
        return List.copyOf(STUDENT_DATABASE);
    }



    public Optional<Student> findById(Long id) {

        if (id == null) {
            return Optional.empty();
        }

        return STUDENT_DATABASE.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }



    public void deleteById(Long id) {
        STUDENT_DATABASE.removeIf(student -> student.getId().equals(id));
    }



    public List<Student> findByMajor(String major) {
        return STUDENT_DATABASE.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .toList();
    }
}
