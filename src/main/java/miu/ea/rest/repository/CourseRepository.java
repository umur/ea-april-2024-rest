package miu.ea.rest.repository;

import miu.ea.rest.entity.Course;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void create(Course course) {
        courses.add(course);
    }

    public Course getById(Long id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void update(Course course) {
        Course existingCourse = getById(course.getId());
        if (existingCourse != null) {
            int index = courses.indexOf(existingCourse);
            if (index != -1) {
                courses.set(index, course);
            }
        }
    }

    public void delete(int id) {
        courses.removeIf(c -> c.getId() == id);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
}