package jsp.controller;

import jsp.domain.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/JDBC/welcome")
public class welcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public welcomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Person person = (Person) request.getSession().getAttribute("person");
        String name = person.getName();
        out.print("<h1>Welcome, " + name + ", 登录成功!</h1>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
