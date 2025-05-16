<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Danh sách phim</h1>
    <c:forEach var="movie" items="${movies}">
        <h1>${movie.title}</h1>
        <p><strong>Đạo diễn:</strong> ${movie.director}</p>
        <p><strong>Thể loại:</strong> ${movie.genre}</p>
        <a href="detailMovie/${movie.id}">Xem chi tiết</a>
    </c:forEach>
</body>
</html>
