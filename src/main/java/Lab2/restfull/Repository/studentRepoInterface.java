package Lab2.restfull.Repository;
import Lab2.restfull.Domain.studentDomain;

import java.util.List;

public interface studentRepoInterface {
    List<studentDomain> getStudents();
    studentDomain getStudentById(int id);
    void saveStudent(studentDomain studentDomain);
    void updateStudent(studentDomain studentDomain);

    void deleteStudent(int id);
}
