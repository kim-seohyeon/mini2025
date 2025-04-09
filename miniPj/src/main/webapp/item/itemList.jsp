<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsList.jsp</title>
</head>
<body>
상품관리<br/>
<a href="itemWrite.mini">상품 추가</a><br />
<table border=1 width="600" align="center">
	<caption>상품 목록</caption>
	<tr><th>번호</th><th>상품번호</th><th>상품명</th><th>상품가격</th></tr>
	<c:forEach items="${list }" var="dto" varStatus="idx">
		<tr>
			<th>${idx.count }</th>
			<th><a href="itemDetail.mini?itemId=${dto.itemId }">${dto.itemId }</a></th>
			<th>${dto.itemName }</th>
			<th>${dto.itemPrice }</th>
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
<title>상품 목록</title>
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
        width: 60%;
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
    .button-container {
        margin-top: 20px;
    }
    .button-container a {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: #28a745;
        color: white;
        text-decoration: none;
        font-weight: bold;
    }
</style>
</head>
<body>
<div class="container">
    <h1>상품 관리</h1>
    <div class="button-container">
        <a href="itemWrite.mini">상품 추가</a>
    </div>
    <table>
        <caption><strong>상품 목록</strong></caption>
        <tr><th>번호</th><th>상품번호</th><th>상품명</th><th>상품가격</th></tr>
        <c:forEach items="${list }" var="dto" varStatus="idx">
            <tr>
                <td>${idx.count }</td>
                <td><a href="itemDetail.mini?itemId=${dto.itemId }">${dto.itemId }</a></td>
                <td>${dto.itemName }</td>
                <td>${dto.itemPrice } 원</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

