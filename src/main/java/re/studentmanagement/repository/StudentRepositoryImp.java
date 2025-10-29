package re.studentmanagement.repository;

import re.studentmanagement.model.Student;
import re.studentmanagement.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImp implements StudentRepository {
    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> listStudents = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_student()}");
            ResultSet rs = callSt.executeQuery();
            listStudents = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStatus(rs.getBoolean("student_status"));
                listStudents.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudents;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_student(?,?,?)}");
            callSt.setString(1, student.getStudentId());
            callSt.setString(2, student.getStudentName());
            callSt.setBoolean(3, student.isStatus());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public Student findById(String studentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_student_by_id(?)}");
            callSt.setString(1, studentId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStatus(rs.getBoolean("student_status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return student;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?)}");
            callSt.setString(1, student.getStudentId());
            callSt.setString(2, student.getStudentName());
            callSt.setBoolean(3, student.isStatus());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(String studentId) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setString(1, studentId);
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public List<Student> findStudentByName(String studentName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> listStudents = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_student_by_name(?)}");
            callSt.setString(1, studentName);
            ResultSet rs = callSt.executeQuery();
            listStudents = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStatus(rs.getBoolean("student_status"));
                listStudents.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudents;
    }
}
