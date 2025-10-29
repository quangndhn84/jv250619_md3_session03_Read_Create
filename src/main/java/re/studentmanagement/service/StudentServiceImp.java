package re.studentmanagement.service;

import re.studentmanagement.model.Student;
import re.studentmanagement.repository.StudentRepository;
import re.studentmanagement.repository.StudentRepositoryImp;

import java.util.List;

public class StudentServiceImp implements StudentService {
    //Tiêm đối tượng studentRepository vào service
    private StudentRepository studentRepository;

    public StudentServiceImp() {
        studentRepository = new StudentRepositoryImp();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(String studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(String studentId) {
        return studentRepository.delete(studentId);
    }

    @Override
    public List<Student> findByName(String studentName) {
        return studentRepository.findStudentByName(studentName);
    }
}
