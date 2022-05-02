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
<%--    表单post请求传递数据--%>
<form action="/test/hello" method="post">
<%--    输入内容设置name,传参时取出name值--%>
    <div>账号:<input name="name"></div>
    <div>密码:<input name="password" type="password"></div>
    <p>个人兴趣:</p>
<%--    checkbox复选框同时还要设置value值--%>
    <label><input type="checkbox" name="interests" value="唱歌">唱歌</label>
    <label><input type="checkbox"  name="interests" value="跳舞">跳舞</label>
    <label><input type="checkbox"  name="interests" value="阅读">阅读</label>
    <label><input type="checkbox"  name="interests" value="编程">编程</label>
    <label><input type="checkbox"  name="interests" value="旅游">旅游</label>
    <br/>
    <br/>
    <input type="submit" class="submit_button">
    <input type="reset" class="reset_button">
</form>
</div>
</body>
</html>
