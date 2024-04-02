package com.ea.studentmanagementapp.repository;

import com.ea.studentmanagementapp.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CourseRepository {

    private static final AtomicLong COURSE_ID_COUNTER = new AtomicLong();
    private static final Set<Course> COURSE_DATABASE = new HashSet<>();



    public Course save(Course course) {
        if (course.getId() == null) {
            course.setId(COURSE_ID_COUNTER.incrementAndGet());
        }
        COURSE_DATABASE.add(course);
        return course;
    }



    public List<Course> findAll() {
        return List.copyOf(COURSE_DATABASE);
    }



    public Optional<Course> findById(Long id) {

        if (id == null) {
            return Optional.empty();
        }

        return COURSE_DATABASE.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }



    public void deleteById(Long id) {
        COURSE_DATABASE.removeIf(course -> course.getId().equals(id));
    }



    public List<Course> findAllById(List<Long> ids) {
        return COURSE_DATABASE.stream()
                .filter(course -> ids.contains(course.getId()))
                .toList();
    }

}
