package Lab2.restfull.Service;

import Lab2.restfull.Domain.studentDomain;
import Lab2.restfull.Repository.studentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    @Autowired
    private studentRepositoryImpl repository;

    public List<studentDomain> getStudents() {
        return repository.getStudents();
    }

    public studentDomain getStudentById(int id) {
        return repository.getStudentById(id);
    }

    public void saveStudent(studentDomain studentDomain) {
        repository.saveStudent(studentDomain);
    }

    public void updateStudent(studentDomain updateStudentDomain) {
        repository.updateStudent(updateStudentDomain);
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }

}
