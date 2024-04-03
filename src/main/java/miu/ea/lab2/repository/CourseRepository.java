package miu.ea.lab2.repository;

import miu.ea.lab2.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CourseRepository {

    private static List<Course> listCourses;

    public CourseRepository() {
        listCourses = new ArrayList<>();
        // Adding sample courses
        listCourses.add(new Course(1L, "Introduction to Computer Science", "CS101"));
        listCourses.add(new Course(2L, "Data Structures and Algorithms", "DSA202"));
        listCourses.add(new Course(3L, "Database Management Systems", "DBMS303"));
        listCourses.add(new Course(4L, "Software Engineering", "SE404"));
        listCourses.add(new Course(5L, "Artificial Intelligence", "AI505"));
        listCourses.add(new Course(6L, "Web Development", "WEB606"));
        listCourses.add(new Course(7L, "Operating Systems", "OS707"));
        listCourses.add(new Course(8L, "Computer Networks", "CN808"));
    }

    //ADD COURSE BY ID
    public Course addCourse(Course course){
        listCourses.add(course);
        return course;
    }

    //GET ALL COURSES BY ID
    public List<Course> getAllCoures(){
        return listCourses;
    }

    //GET COURSE BY ID
    public Course getCourseById(Long id){
        return listCourses.stream().filter(l -> l.getId()==id).findFirst().get();
    }

    //UPDATE COURSE BY ID
    public Course updateCourse(Course course){

        for (int i=0; i< listCourses.size(); i++){
            if(listCourses.get(i).getId()==course.getId()){
                listCourses.get(i).setName(course.getName());
                listCourses.get(i).setCode(course.getCode());
                break;
            }
        }
        return course;
    }

    //DELETE COURSE BY ID
    public Course deleteCourse(Long id){
        Course deleteCourse = null;

        for (int i=0; i< listCourses.size(); i++){
            if(listCourses.get(i).getId()==id){
                deleteCourse = listCourses.get(i);
                listCourses.remove(i);
                break;
            }
        }
        return deleteCourse;
    }
}
