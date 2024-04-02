package miu.ea.lab2.repository;

import miu.ea.lab2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public void update(Course course) {
        Course updatedCourse = courses.stream().filter(c -> c.getId() == course.getId()).findFirst().get();
        if (updatedCourse == null) {
            throw new RuntimeException("Course does not exist");
        }
        updatedCourse.setCode(course.getCode());
        updatedCourse.setName(course.getName());
    }

    public void delete(Long id) {
        Course deletedCourse = courses.stream().filter(c -> c.getId() == id).findFirst().get();
        if (deletedCourse == null) {
            throw new RuntimeException("Course does not exist");
        }
        courses.remove(deletedCourse);
    }

    public List<Course> getAll() {
        return this.courses;
    }

    public Course getById(Long id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().get();
    }
}
