package com.sonny.ea.rest;

import com.sonny.ea.rest.interfaces.IStudentService;
import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;
import com.sonny.ea.rest.repository.CourseRepository;
import com.sonny.ea.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    IStudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course1 = new Course(1L);
        course1.setCode("EA");
        course1.setName("Enterprise Architecture");

        Course course2 = new Course(2L);
        course2.setCode("WAP");
        course2.setName("Web Application Programming");

        Course course3 = new Course(3L);
        course3.setCode("MPP");
        course3.setName("Modern Programming");

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);


        Student student1 = new Student(1L);
        student1.setFirstName("Sonny");
        student1.setLastName("Truong");
        student1.setMajor("java");

        Student student2 = new Student(2L);
        student2.setFirstName("Katty");
        student2.setLastName("Truong");
        student2.setMajor("springboot");

        studentRepository.save(student1);
        studentRepository.save(student2);


        studentService.addCourse(1,1);
        studentService.addCourse(1,2);

        studentService.addCourse(2,3);
        studentService.addCourse(2,2);
    }
}
