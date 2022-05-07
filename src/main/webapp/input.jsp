<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--注册页面设置样式--%>
<style>
    .register{
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .reset_button{
        margin-left: 100px;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<div class="register">
<p>用户注册页面</p>
<%--    表单post请求传递数据 ${pageContext.request.contextPath}--%>
<form action="${pageContext.request.contextPath}/register" method="post">
<%--    输入内容设置name,传参时取出name值--%>
    <div>账号:<input name="id"></div>
    <div>姓名:<input name="name"></div>
    <div>密码:<input name="password" type="password"></div>
    <div>生日:<input name="birthday" type="date"></div>
    <br/>
    <input type="submit" class="submit_button">
    <input type="reset" class="reset_button">
</form>
</div>
</body>
</html>
