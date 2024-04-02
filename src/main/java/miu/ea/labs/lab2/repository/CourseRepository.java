package miu.ea.labs.lab2.repository;

import miu.ea.labs.lab2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Collection;
import java.util.Map;

@Repository
public class CourseRepository {
    private Map<Long, Course> courses = new HashMap<Long, Course>();

    public Course save(Course course) {
        courses.put(course.getId(), course);
        return course;
    }

    public Course update(Course course) throws Exception {
        if(!courses.containsKey(course.getId())) throw new Exception("Course not found");
        return save(course);
    }

    public void delete(Long id){
        courses.remove(id);
    }

    public Course findCourse(Long id) throws Exception {
        if(!courses.containsKey(id)) throw new Exception("Course not found");
        return courses.get(id);
    }

    public Collection<Course> findAll() {
        return courses.values();
    }

}
