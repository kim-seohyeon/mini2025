<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ownerList.jsp</title>
</head>
<body>

<table border=1 width="600" align="center">
	<caption>대여한 물건 목록</caption>
	<tr><th>번호</th><th>상품명</th><th>대여날짜</th><th>반납날짜</th>
		<th>수량</th><th>총 대여금액</th><th>상태</th>
	</tr>
	<c:forEach items="${list }" var="dto" varStatus="idx">
		<tr>
			<th>${idx.count }</th>
			<th>${dto.itemName }</th>
			<th>${dto.rentalStart }</th>
			<th>${dto.rentalEnd }</th>
			<th>${dto.itemQty }</th>
			<th>${dto.itemRentalPrice }</th>
			<th>
			 <c:if test="${dto.rentalEnd == null}">대여중</c:if>
			 <c:if test="${dto.rentalEnd != null}">반납완료</c:if>
			</th>
		</tr>
	</c:forEach>
</table>
</body>
</html>
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여한 물건 목록</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
        text-align: center;
    }
    .container {
        background: white;
        width: 80%;
        padding: 20px;
        margin: auto;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #007bff;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<div class="container">
    <h1>대여한 물건 목록</h1>
    <table>
        <tr>
            <th>번호</th><th>상품명</th><th>대여날짜</th><th>반납날짜</th>
            <th>수량</th><th>총 대여금액</th><th>상태</th>
        </tr>
        <c:forEach items="${list }" var="dto" varStatus="idx">
            <tr>
                <td>${idx.count }</td>
                <td>${dto.itemName }</td>
                <td>${dto.rentalStart }</td>
                <td>${dto.rentalEnd }</td>
                <td>${dto.itemQty }</td>
                <td>${dto.itemRentalPrice }</td>
                <td>
                    <c:if test="${dto.rentalEnd == null}">대여중</c:if>
                    <c:if test="${dto.rentalEnd != null}">반납완료</c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
 