<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<form action="login" method="post">
    <label for="username">Tên đăng nhập:</label>
    <input type="text" name="username" id="username" required>
    <label for="password">Mật khẩu:</label>
    <input type="password" name="password" id="password" required>
    <input type="submit" value="Login">
</form>
</body>
</html>
