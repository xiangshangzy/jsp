<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--表单提交给DispatcherServlet类处理,必须包含虚拟路径变量--%>
<form method="post" action="loginValidate.jsp">
    <%--    在input的name中设置请求头属性--%>
    <label>用户名:<input name="name"></label>
    <br/>
    <label>用户密码:<input name="password" type="password"></label>
    <br/>
    <button type="submit">login</button>
    <button type="reset">reset</button>
</form>
</body>
</html>
