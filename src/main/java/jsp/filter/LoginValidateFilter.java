package jsp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebFilter(filterName = "loginFilter", urlPatterns = "/hello")
public class LoginValidateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        System.out.println("登陆验证过滤");
        if (session.getAttribute("name") != null && session.getAttribute("name").equals("admin")) {
            chain.doFilter(request, response);
        } else {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write("未登录,2秒后跳转登录页面");
            ((HttpServletResponse) response).setHeader("refresh", "2;url=" + contextPath + "/login.jsp");
            return;
        }
    }
}
