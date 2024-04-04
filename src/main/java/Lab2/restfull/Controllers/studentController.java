package Lab2.restfull.Controllers;

import Lab2.restfull.Domain.courseDomain;
import Lab2.restfull.Domain.studentDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Lab2.restfull.Service.studentService;

import java.util.List;


@RestController
@RequestMapping("/students")
public class studentController {
    @Autowired
    private studentService studentService;
    @GetMapping()
    public List<studentDomain> getStudents() { return studentService.getStudents();  }
    @GetMapping("/{id}")
    public studentDomain getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    @PostMapping
    public void saveStudent(@RequestBody studentDomain studentDomain) {studentService.saveStudent(studentDomain); }
    @PutMapping()
    public void updateStudent(@RequestBody studentDomain updatedStudentDomain) {
        studentService.updateStudent(updatedStudentDomain);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
