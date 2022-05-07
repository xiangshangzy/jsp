<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--设置范围为application的bean,以便多次请求共享bean数据--%>
<jsp:useBean id="student" class="jsp.domain.Student" scope="application"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //从post请求中获得值
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    //bean实例设置属性值
    student.setName(name);
    student.setPassword(password);
    student.setName(name);
    student.setPassword(password);
    request.getSession().setAttribute("Student", student);
    //重定向到注册成功页面
    response.sendRedirect("JDBC/welcome");
    
%>
</body>
</html>
