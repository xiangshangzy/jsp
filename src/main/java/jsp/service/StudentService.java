package jsp.service;

import jsp.dao.StudentDao;
import jsp.domain.Student;

public class StudentService {
    StudentDao dao = new StudentDao();

    public boolean register(Student student) {
        int count = dao.idCount(student.getId());
        if (count == 0) {
            dao.insertStudent(student);
            return true;
        }
        return false;
    }

    public Student login(String id, String password) {

        return dao.queryStudent(id, password);
    }
}
