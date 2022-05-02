<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获取application范围的student实例--%>
<jsp:useBean id="student" class="jsp.bean.Student" scope="application"/>
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
    <p> 注册成功!</p>

<%--    调用student实例的get方法获取值--%>
    <p>账号:<%=student.getName()%>
    </p>
    <p>密码:<%=student.getPassword()%>
    </p>
    <p>兴趣:<%=Arrays.toString(student.getInterests())%>
    </p>
</div>
</body>
</html>
