package re.studentmanagement.repository;

import re.studentmanagement.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    boolean save(Student student);

}
