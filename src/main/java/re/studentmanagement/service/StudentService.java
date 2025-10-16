package re.studentmanagement.service;

import re.studentmanagement.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    boolean save(Student student);
}
