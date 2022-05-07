<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获取application范围的student实例--%>
<jsp:useBean id="student" class="jsp.domain.Student" scope="session"/>
<html>
<%--注册成功页面设置样式--%>
<style>
    .success {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<div class="success">
    <p> 恭喜你,注册成功!</p>

<%--    调用student实例的get方法获取值--%>
    <p>账号:<%=student.getId()%></p>
    <p>姓名:<%=student.getName()%></p>
    <p>密码:<%=student.getPassword()%></p>
    <p>生日:<%=student.getBirthDate()%></p>
</div>
</body>
</html>
