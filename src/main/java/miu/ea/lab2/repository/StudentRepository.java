package miu.ea.lab2.repository;

import miu.ea.lab2.entity.Course;
import miu.ea.lab2.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentRepository {

    private static List<Student> listStudent;

    public StudentRepository(){
    // Create and add dummy student data
        listStudent = new ArrayList<>();
        // Create and add dummy student data with courses
        listStudent.add(new Student(1L, "John", "Doe", "john.doe@example.com", "Computer Science", "3.8", Arrays.asList(
                new Course(1L, "Introduction to Computer Science", "CS101"),
                new Course(2L, "Data Structures and Algorithms", "DSA202"))));

        listStudent.add(new Student(2L, "Alice", "Smith", "alice.smith@example.com", "Mathematics", "3.5", Arrays.asList(
                new Course(3L, "Database Management Systems", "DBMS303"),
                new Course(4L, "Artificial Intelligence", "AI505"))));

        listStudent.add(new Student(3L, "Emily", "Johnson", "emily.johnson@example.com", "Physics", "3.9", Arrays.asList(
                new Course(5L, "Introduction to Computer Science", "CS101"),
                new Course(3L, "Database Management Systems", "DBMS303"),
                new Course(4L, "Software Engineering", "SE404"))));

        listStudent.add(new Student(4L, "Michael", "Brown", "michael.brown@example.com", "Chemistry", "3.6", Arrays.asList(
                new Course(1L, "Introduction to Computer Science", "CS101"),
                new Course(2L, "Data Structures and Algorithms", "DSA202"),
                new Course(3L, "Database Management Systems", "DBMS303"))));

        listStudent.add(new Student(5L, "Emma", "Davis", "emma.davis@example.com", "Biology", "3.7", Arrays.asList(
                new Course(4L, "Software Engineering", "SE404"),
                new Course(6L, "Web Development", "WEB606"))));

        listStudent.add(new Student(6L, "Quyen", "Bui", "alice.smith@example.com", "Mathematics", "3.5", Arrays.asList(
                new Course(3L, "Database Management Systems", "DBMS303"),
                new Course(4L, "Artificial Intelligence", "AI505"))));
    }

    //CRUD of student
    //Add new Student
    public Student addStudent(Student student){
        listStudent.add(student);
        return student;
    }

    //Get all student
    public List<Student> getAllStudents(){
        return listStudent;
    }

    //Get student by id
    public Student getStudentById(Long id){
        return listStudent.stream().filter(s->s.getId()== id).findFirst().get();
    }

    //Update student
    public Student updateStudent(Student updateStudent){
        for(int i=0; i<listStudent.size();i++){
            if (listStudent.get(i).getId() == updateStudent.getId()) {
                listStudent.get(i).setFirstName(updateStudent.getFirstName());
                listStudent.get(i).setLastName(updateStudent.getLastName());
                listStudent.get(i).setEmail(updateStudent.getEmail());
                listStudent.get(i).setMajor(updateStudent.getMajor());
                listStudent.get(i).setGpa(updateStudent.getGpa());
                listStudent.get(i).setListCoursesTaken(updateStudent.getListCoursesTaken());
                break;
            }
        }
        return updateStudent;
    }

    //Delete student
    public Student deleteStudent(Long id){
        Student deletedStudent = null;
        for(int i=0; i<listStudent.size();i++){
            if (listStudent.get(i).getId() == id) {
                deletedStudent = listStudent.get(i);
                listStudent.remove(i);
                break;
            }
        }
        return deletedStudent;
    }

//    Implement getStudentsByMajor(String major) method.
//    Returns all students majoring major.

    public List<Student> getStudentsByMajor(String major){
        return listStudent.stream()
                .filter(s->s.getMajor().equals(major))
                .collect(Collectors.toList());

    }

//    Implement getCoursesByStudentId(int studentId) method.
//    Returns all courses of the student.
    public List<Course> getCourseByStudentId(Long id){
        return listStudent.stream()
                .filter(s->s.getId()==id)
                .findFirst().get().getListCoursesTaken();
    }
}
