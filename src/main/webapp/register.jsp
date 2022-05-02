<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--设置范围为application的bean,以便多次请求共享bean数据--%>
<jsp:useBean id="student" class="jsp.bean.Student" scope="application"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //从post请求中获得值
    String[] interests = request.getParameterValues("interests");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    //bean实例设置属性值
    student.setName(name);
    student.setPassword(password);
    student.setInterests(interests);
    //重定向到注册成功页面
    response.sendRedirect("registerSuccess.jsp");
%>
</body>
</html>
