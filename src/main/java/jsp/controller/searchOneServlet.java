package jsp.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jsp.domain.Person;
import jsp.service.PersonService;
/**
 * searchOneServlet
 */
@WebServlet("/JDBC/searchOneServlet")
public class searchOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public searchOneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//接收并解析request传入的参数，存入bean
		String id=request.getParameter("id");

		//System.out.println(name+":"+password);
		Person person=new Person();
		System.out.println("id: "+id);
		person.setID(id);
		
		//调用service查询用户
		PersonService service=new PersonService();
		person=service.login(person);
		
		//生成响应，将结果转发到View
		PrintWriter out=response.getWriter();
		if(person!=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("person", person);
			request.getRequestDispatcher("/JDBC/welcome").include(request, response);
	    }else {
			out.print("用户未注册，请先注册，将转到注册页面。");
			response.setHeader("refresh", "3;url=login1.jsp");	//重定向到注册页面	
		}
	}
}
