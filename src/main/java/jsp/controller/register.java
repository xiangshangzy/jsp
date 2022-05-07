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


@WebServlet("/register")

public class register extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String birthday = req.getParameter("birthday");
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPassword(password);
        if (birthday== null||birthday.equals("")) {
            birthday = "1970-01-01";
        }
        try {
            student.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean status=studentService.register(student);
        if (status) {
            System.out.println("用户注册成功");
            req.getSession().setAttribute("student", student);
            req.getRequestDispatcher("registerSuccess.jsp").include(req, resp);
        } else {
            System.out.println("用户ID已存在");
            resp.getWriter().print("该用户ID已存在，重新转到注册页面。");
            resp.setHeader("refresh", "3;url=input.jsp");	//重定向到注册页面
        }
    }
}
