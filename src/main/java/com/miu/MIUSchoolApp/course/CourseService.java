package com.miu.MIUSchoolApp.course;

import com.miu.MIUSchoolApp.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        return this.courseRepository.getCourses();
    }

    public String addCourse(Course course) {
        if( course.getCode().equals("") || course.getName().equals("") ) {
            return "Course have empty field.";
        }
        this.courseRepository.addCourse(course);
        return "Successfully added.";
    }

    public String updateCourse(Course course) {
        if( course.getCode().equals("") || course.getName().equals("") ) {
            return "Course have empty field.";
        }
        this.courseRepository.updateCourse(course);
        return "Successfully updated.";
    }

    public String deleteCourse(Course course) {

        long linkedStudents = this.studentRepository.getStudentsByCourse(course);
        if ( linkedStudents>0 ) {
            return "This course linked to students";
        }
        this.courseRepository.deleteCourse(course);
        return "Successfully deleted.";
    }
}
