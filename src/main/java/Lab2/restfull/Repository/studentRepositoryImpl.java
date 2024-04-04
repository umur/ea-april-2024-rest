package Lab2.restfull.Repository;

import Lab2.restfull.Domain.studentDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.IntStream;
@Repository
public class studentRepositoryImpl implements studentRepoInterface{
    @Autowired
    private PopulatedData populatedData;

    @Override
    public List<studentDomain> getStudents() { return populatedData.students; }



    @Override
    public studentDomain getStudentById(int id) {
        return populatedData.students.stream().filter((x) -> x.getId() == id). findFirst().orElse(null);
    }

    @Override
    public void saveStudent(studentDomain studentDomain) { populatedData.students.add(studentDomain); }



    @Override
    public void updateStudent(studentDomain updateStudentdomain) {
        int index = IntStream.range(0, populatedData.students.size())
                .filter(i -> populatedData.students.get(i).getId() == updateStudentdomain.getId())
                .findFirst()
                .orElse(-1);
        populatedData.students.set(index, updateStudentdomain);
    }

    @Override
    public void deleteStudent(int id){
        populatedData.students.remove(populatedData.students.stream().filter((x) -> x.getId() == id).findFirst().orElse(null));
    }
}
