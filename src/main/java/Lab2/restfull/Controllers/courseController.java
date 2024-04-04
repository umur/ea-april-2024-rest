package Lab2.restfull.Controllers;

import Lab2.restfull.Domain.courseDomain;
import Lab2.restfull.Service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class courseController {
    @Autowired
    private courseService courseService;
    @GetMapping()
    public List<courseDomain> getCourses(){
        return courseService.getCourses();
    }
    @GetMapping("/{id}")
    public courseDomain getCourse(@PathVariable int id){
        return courseService.getCourseById(id);
    }
    @PostMapping
    public String saveCourse(@RequestBody courseDomain courseDomain) {
       courseService.saveCourse(courseDomain);
        return "Success";
    }
    @PutMapping()
    public void updateCourse(@RequestBody courseDomain updatedCourseDomain) {
        courseService.updateCourse(updatedCourseDomain);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
       courseService.deleteCourse(id);
    }
}
