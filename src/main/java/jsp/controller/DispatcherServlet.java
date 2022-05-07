package jsp.controller;

import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

//设置servlet的虚拟路径
@WebServlet("/dispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传递过来的用户名和密码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //检验name和password是否正确
        if (name.equals("admin") && password.equals("12345")) {
            //若正确则在session设置属性，以便跳转页面获取
            req.getSession().setAttribute("name", name);
            //设置链接页面
            req.getRequestDispatcher("/welcome").forward(req, resp);
        } else {
            //响应设置中文编码
            resp.setContentType("text/html; charset=utf-8");
            Writer writer = resp.getWriter();
            //响应体设置消息
            String message = "尝试登录名: " + name + " 用户名或用户密码错误";
            writer.write(message);
            //响应体携带登录jsp文件
            req.getRequestDispatcher("login.jsp").include(req, resp);
        }
    }
}
