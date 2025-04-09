<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemRental.jsp</title>
</head>
<body>

<table width="700" align="center">
	<tr><td>상품 대표 이미지</td><td>주문 상품 정보</td><td>수량/상품금액</td><td>금액</td></tr>
	
	<c:forEach items="${list }" var="dto">
	
		<tr>
			<td><img src="item/upload/${dto.itemImage }" width=30/></td>
			<td>${dto.itemName }</td>
			<td>${dto.cartQty }개/${dto.itemsTotalPrice }원</td>
			<td>${dto.itemsTotalPrice }원</td>
		</tr>
	
	
	</c:forEach>

</table>
<br/><br/>

<form action="itemRentals.mini" method="post"> 
<input type="hidden" name="purchaseName" value="${list[0].itemName }'외' ${list.size() -1}개"/>
<input type="hidden" name="itemId" value="${nums }"/>
<input type="hidden" name="itemsTotalPrice" value="${itemsTotalPrice }" />
<table width="700"  align="center">

	<tr>
		<td>
			<table width="350">
				<tr><td colspan=2>2. 대여결제정보</td></tr>
				<tr><td><c:if test="${list.size() > 1}">${list[0].itemName }'외' ${list.size() -1}개</c:if>
						<c:if test="${list.size() <= 1}">${list[0].itemName }</c:if>
				</td></tr>
				<tr><td> 총 대여 금액 : ${itemsTotalPrice } 원</td>
				<tr><td colspan=2><input type="submit" value="대여하기"/></td></tr>
			</table>
		</td>
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
<title>대여 상품 결제</title>
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
    .button-container input {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: #007bff;
        color: white;
        cursor: pointer;
    }
</style>
</head>
<body>
<div class="container">
    <h1>대여 상품 결제</h1>
    <table>
        <tr><th>상품 대표 이미지</th><th>주문 상품 정보</th><th>수량/상품금액</th><th>금액</th></tr>
        
        <c:forEach items="${list }" var="dto">
            <tr>
                <td><img src="item/upload/${dto.itemImage }" width=50/></td>
                <td>${dto.itemName }</td>
                <td>${dto.cartQty }개 / ${dto.itemsTotalPrice }원</td>
                <td>${dto.itemsTotalPrice }원</td>
            </tr>
        </c:forEach>
    </table>
    
    <form action="itemRentals.mini" method="post"> 
        <input type="hidden" name="purchaseName" value="${list[0].itemName }'외' ${list.size() -1}개"/>
        <input type="hidden" name="itemId" value="${nums }"/>
        <input type="hidden" name="itemsTotalPrice" value="${itemsTotalPrice }" />
        <table>
            <tr>
                <td><strong>총 대여 금액 :</strong> ${itemsTotalPrice } 원</td>
            </tr>
            <tr>
                <td class="button-container"><input type="submit" value="대여하기"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
