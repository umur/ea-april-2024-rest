package com.miu.MIUSchoolApp.student;

import com.miu.MIUSchoolApp.course.Course;
import com.miu.MIUSchoolApp.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getStudents() {
        return this.studentRepository.getStudents();
    }

    public String addStudent(Student student) {

        for (Course course: student.getCoursesTaken()) {

            if( course.getCode().equals("") || course.getName().equals("") ) {
                return "Course have empty field.";
            }

            if (course.getId() == 0 ) {
                this.courseRepository.addCourse(course);
            } else {
                Course existed= this.courseRepository.findById(course.getId());
                if( existed == null || (existed.getName().equals(course.getName()) && existed.getCode().equals(course.getCode())) ) {
                    return "Error !!! Entered, '" + course.getName() + "' course does not match with courses";
                }
            }
        }

        this.studentRepository.addStudent(student);
        //System.out.println(student);
        return "Successfully added.";
    }

    public String updateStudent(Student student) {

        for (Course course: student.getCoursesTaken()) {
            if (course.getId() == 0 ) {
                this.courseRepository.addCourse(course);
            } else {
                Course existed= this.courseRepository.findById(course.getId());
                if( existed == null || (existed.getName().equals(course.getName()) && existed.getCode().equals(course.getCode())) ) {
                    return "Error !!! Entered, '" + course.getName() + "' course does not match with courses";
                }
            }
        }

        this.studentRepository.updateStudent(student);
        return "Successfully updated.";
    }

    public Object deleteStudent(Student student) {
        this.studentRepository.deleteStudent(student);
        return "Successfully deleted.";
    }

    public List<Student> getStudentsByMajor(MajorDTO majorDTO) {
        return this.studentRepository.getStudentsByMajor(majorDTO.getMajor());
    }

    public List<Course> getCoursesByStudentId(StudentDTO studentDTO) {
        return this.studentRepository.getCoursesByStudentId(studentDTO.getStudentId());
    }
}
