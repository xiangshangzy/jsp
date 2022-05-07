package jsp.controller;

import jsp.domain.Student;
import jsp.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/login")

public class login extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        Student student = studentService.login(id, password);
        if (student != null) {
            req.getSession().setAttribute("student", student);
        } else {
            resp.sendRedirect("input.jsp");
        }
    }
}
