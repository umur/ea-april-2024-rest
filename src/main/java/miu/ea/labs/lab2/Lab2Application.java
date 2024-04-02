package miu.ea.labs.lab2;

import miu.ea.labs.lab2.model.Course;
import miu.ea.labs.lab2.model.Student;
import miu.ea.labs.lab2.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	StudentRepository initStudentData(){
		Course course1 = new Course(1L, "Modern Programming", "CS111");
		Course course2 = new Course(2L, "Web Programming", "CS222");
		Course course3 = new Course(3L, "Enterprise Architecture", "CS333");
		Course course4 = new Course(4L, "Data Structure", "CS444");
		StudentRepository studentRepository = new StudentRepository();
		studentRepository.save(new Student(1L, "First1", "Last1",
				"email1@ea.com", "major1", 3.8,
				Arrays.asList(course1, course2, course3, course4)));
		studentRepository.save(new Student(2L, "First2", "Last2",
				"email2@ea.com", "major2", 3.8,
				Arrays.asList(course1, course2, course3)));
		studentRepository.save(new Student(3L, "First3", "Last3",
				"email3@ea.com", "major1", 3.8,
				Arrays.asList(course1, course2, course4)));

		return studentRepository;
	}
}
