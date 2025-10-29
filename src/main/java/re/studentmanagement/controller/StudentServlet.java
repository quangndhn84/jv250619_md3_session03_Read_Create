package re.studentmanagement.controller;

import re.studentmanagement.model.Student;
import re.studentmanagement.service.StudentService;
import re.studentmanagement.service.StudentServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
//Context: http://localhost:8080
//URL Servlet: http://localhost:8080/StudentServlet
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    public StudentServlet() {
        studentService = new StudentServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllStudents(request, response);
        } else if (action.equals("initUpdate")) {
            String studentId = request.getParameter("studentId");
            Student student = studentService.findById(studentId);
            request.setAttribute("student", student);
            request.getRequestDispatcher("views/updateStudent.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            String studentId = request.getParameter("studentId");
            boolean result = studentService.delete(studentId);
            if (result) {
                findAllStudents(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }

        }

    }

    public void findAllStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. Goi sang service lay thong tin sinh vien
        List<Student> listStudents = studentService.findAll();
        //2. Chuyển thông tin sinh viên sang view để hiển thị
        //--2.1. add listStudents vào request
        request.setAttribute("listStudents", listStudents);
        //--2.2. Chuyển cả request và response sang students.jsp
        request.getRequestDispatcher("views/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Tiến hành thêm mới dữ liệu hoặc cập nhật dữ liệu
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");//Create
        if (action.equals("Create")) {
            //Tiến hành thêm mới sinh viên
            //1. Lấy thông tin sinh viên trên form newStudent.jsp
            Student student = new Student();
            student.setStudentId(request.getParameter("studentId"));
            student.setStudentName(request.getParameter("studentName"));
            student.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //2. Gọi sang service thêm mới sinh viên
            boolean result = studentService.save(student);
            //3. Xử lý kết quả thêm mới
            if (result) {
                findAllStudents(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action.equals("Update")) {
            //Thực hiện update
            //- Lấy dữ liệu trên form
            Student student = new Student();
            student.setStudentId(request.getParameter("studentId"));
            student.setStudentName(request.getParameter("studentName"));
            student.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //- Gọi service tiến hành cập nhật
            boolean result = studentService.update(student);
            //- Cập nhật thành công hiển thị danh sách sinh viên
            if (result) {
                findAllStudents(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action.equals("Search")) {
            String studentName = request.getParameter("searchName");
            List<Student> listStudents = studentService.findByName(studentName);
            request.setAttribute("listStudents", listStudents);
            request.getRequestDispatcher("views/students.jsp").forward(request, response);
        }
    }
}