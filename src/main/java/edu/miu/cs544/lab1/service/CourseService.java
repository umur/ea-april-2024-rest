package edu.miu.cs544.lab1.service;

import edu.miu.cs544.lab1.entity.Course;
import edu.miu.cs544.lab1.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo courseRepo;

    public void save(Course course) {
        courseRepo.save(course);
    }

    public void deleteCourse(int id) {
        courseRepo.deleteCourse(id);
    }

    public void updateCourse(Course course) {
        courseRepo.updateCourse(course);
    }

    public Course getCourse(int id) {
        return courseRepo.getCourse(id);
    }

    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }
}
