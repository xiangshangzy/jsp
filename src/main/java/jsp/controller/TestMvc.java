package jsp.controller;
import jsp.domain.Student;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/testMvc")
public class TestMvc extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application=this.getServletContext();
        Student student=new Student();
        student.setPassword("123456");
        student.setName("user");
        req.getSession().setAttribute("student_key",student);
//        req.getRequestDispatcher("TestMvc.jsp").forward(req,resp);
    }
}
