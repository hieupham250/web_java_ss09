<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt vé</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/tickets/book" method="post">
    <input type="hidden" name="scheduleId" value="${scheduleId}" />
    <input type="hidden" name="screenRoomId" value="${screenRoomId}" />
    <input type="hidden" name="customerId" value="${customerId}" />

    <table>
        <tr>
            <th>Ghế</th>
            <th>Trạng thái</th>
            <th>Chọn</th>
        </tr>
        <c:forEach var="seat" items="${seats}">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${bookedSeats.contains(seat.id)}">
                            <span style="color:red;">Đã đặt</span>
                        </c:when>
                        <c:otherwise>
                            <span style="color:green;">Trống</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${!bookedSeats.contains(seat.id)}">
                        <p>${seat.id}</p>
                        <input type="radio" name="seatId" value="${seat.id}" />
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

    <button type="submit">Đặt vé</button>
</form>
</body>
</html>
