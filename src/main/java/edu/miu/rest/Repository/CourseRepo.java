package edu.miu.rest.Repository;

import edu.miu.rest.Entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(long id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(long id, Course course) {
        courses.stream()
                .filter(c -> c.getId() == id)
                .forEach(filCourse -> {
                    filCourse.setId(course.getId());
                    filCourse.setName(course.getName());
                    filCourse.setCode(course.getCode());
                });
    }

    public void deleteCourse(long id) {
        courses.removeIf(c -> c.getId() == id);
    }
}
