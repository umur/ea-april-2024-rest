package com.miu.MIUSchoolApp.course;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> listCourse = new ArrayList<>();

    public int getMaxId() {
        return this.listCourse.stream().mapToInt(Course::getId).max().orElse(0) + 1;
    }

    public List<Course> getCourses() {
        return this.listCourse;
    }

    public void addCourse(Course course) {
        course.setId(this.getMaxId());
        listCourse.add(course);
    }

    public void updateCourse(Course course) {
        for (Course obj : listCourse) {
            if (obj.getId() == course.getId()) {
                obj.setCode(course.getCode());
                obj.setName(course.getName());
            }
        }
    }

    public void deleteCourse(Course course) {
        for (Course obj : listCourse) {
            if (obj.getId() == course.getId()) {
                listCourse.remove(obj);
                break;
            }
        }
    }

    public Course findById(int id) {

        for (Course obj : listCourse) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }
}
