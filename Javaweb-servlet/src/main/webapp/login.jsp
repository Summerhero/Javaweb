
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label>用户名称:</label><input type="text" name="username" placeholder="请输入用户名"><br>
            <label>用户密码:</label><input type="password" name="userpwd" placeholder="请输入用户密码"><br>
            <button type="submit">登录</button>
            <button type="reset">重置</button>
        </form>

    </div>
</body>
</html>
