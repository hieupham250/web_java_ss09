<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết phim</title>
</head>
<body>
<h1>${movie.title}</h1>
<p>Đạo diễn: ${movie.director}</p>
<p>Thể loại: ${movie.genre}</p>
<p>Ngôn ngữ: ${movie.language}</p>
<p>Thời lượng: ${movie.duration} phút</p>
<p>Mô tả: ${movie.description}</p>
<a href="${pageContext.request.contextPath}/movies/${movie.id}/schedules?customerId=${customerId}">Đặt vé</a>

<br>
<a href="${pageContext.request.contextPath}/home">Quay lại danh sách</a>
</body>
</html>
