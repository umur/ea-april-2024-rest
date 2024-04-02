package com.david.lab.course;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    private static long LAST_USED_ID = 0;

    private final static List<Course> COURSES = new ArrayList<>() {{
        add(new Course(++LAST_USED_ID, "STC Pt 1- ComPro (Science and Technology of Consciousness)", "STC506A"));
        add(new Course(++LAST_USED_ID, "Modern Programming Practices", "CS401"));
        add(new Course(++LAST_USED_ID, "Enterprise Architecture", "CS544"));
        add(new Course(++LAST_USED_ID, "Advanced Software Development", "CS525"));
        add(new Course(++LAST_USED_ID, "Software Engineering", "CS425"));
        add(new Course(++LAST_USED_ID, "Algorithms", "CS435"));
        add(new Course(++LAST_USED_ID, "STC Pt2 Leadership for Tech Managers", "STC506B"));
        add(new Course(++LAST_USED_ID, "Career Strategies for Information Technology", "MGT5341"));
    }};

    public List<Course> getAllCourses() {
        return COURSES;
    }

    public Optional<Course> getCourseById(long id) {
        return COURSES.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

    public Course addCourse(Course course) {
        course.setId(++LAST_USED_ID);
        COURSES.add(course);
        return course;
    }

    public Optional<Course> updateCourse(Course courseToUpdate) {
        return COURSES.stream()
                .filter(course -> course.getId() == courseToUpdate.getId())
                .map(course -> courseToUpdate)
                .findAny();
    }

    public void deleteCourse(long id) {
        COURSES.removeIf(course -> course.getId() == id);
    }
}