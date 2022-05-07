<%--
  Created by IntelliJ IDEA.
  User: xiangshangzy
  Date: 2022/4/26
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student_key" class="jsp.domain.Student" scope="session"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>账号:<%=student_key.getName()%>
</p>
<p>密码:<%=student_key.getPassword()%>
</p>
</body>
</html>
