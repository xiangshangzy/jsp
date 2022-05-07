package jsp.filter;

import jsp.domain.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebFilter(filterName = "loginValidateFilter", urlPatterns = "/JDBC/welcome")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String URL = ((HttpServletRequest) request).getRequestURI();
        if (URL.contains("login.jsp") || URL.contains("LoginValidateServlet")) {
            chain.doFilter(request, response);
        } else {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            HttpSession session = ((HttpServletRequest) request).getSession(true);
            Student student = (Student) session.getAttribute("Student");
            if (student == null) {
                Writer writer = response.getWriter();
                writer.write("用户未登录,2秒后跳转登录页面");
                ((HttpServletResponse) response).setHeader("refresh", "2;url=" + contextPath + "/login.jsp");
                return;
            } else {
                chain.doFilter(request, response);
            }
        }
    }
}
