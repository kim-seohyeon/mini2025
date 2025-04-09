<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList.jsp</title>
</head>
<body>
<form action="itemRental.mini" method="post">
<table width=600 align="center">
<caption>장바구니</caption>
	<tr><td><input type = "checkbox" id="checkBoxes" checked="checked"/></td>
		<td>이미지</td><td>제품이름</td><td>수량</td><td>합계금액</td></tr>
	
	<c:forEach items="${list }" var="dto">	
	<tr><td><input type = "checkbox" name="prodCk" value="${dto.itemId }" checked="checked"/></td>
		<td><img src="item/upload/${dto.itemImage }" width=30/></td><td>${dto.itemName }</td>
		<td>${dto.cartQty }</td><td>${dto.itemsTotalPrice }</td></tr>
	</c:forEach>
 	
	<tr>
		<td colspan=5 align="right"><input type="submit" value="대여하기"></td>
	</tr>
</table>
</form>
</body>
</html>
 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
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
        text-align: left;
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
    input[type="checkbox"] {
        transform: scale(1.2);
    }
    input, button {
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    button {
        background-color: #28a745;
        color: white;
        font-weight: bold;
        cursor: pointer;
        padding: 10px 15px;
        border: none;
    }
    button:hover {
        background-color: #218838;
    }
</style>
</head>
<body>
<div class="container">
    <h1>장바구니</h1>
    <form action="itemRental.mini" method="post">
        <table>
            <tr>
                <th><input type="checkbox" id="checkBoxes" checked="checked"/></th>
                <th>이미지</th>
                <th>제품이름</th>
                <th>수량</th>
                <th>합계금액</th>
            </tr>
            
            <c:forEach items="${list }" var="dto">
                <tr>
                    <td><input type="checkbox" name="prodCk" value="${dto.itemId }" checked="checked"/></td>
                    <td><img src="item/upload/${dto.itemImage }" width="50"/></td>
                    <td>${dto.itemName }</td>
                    <td>${dto.cartQty }</td>
                    <td><fmt:formatNumber value="${dto.itemsTotalPrice }" pattern="###,###,###,###"/>원</td>
                </tr>
            </c:forEach>
            
            <tr>
                <td colspan="5" align="right">
                    <button type="submit">대여하기</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
 