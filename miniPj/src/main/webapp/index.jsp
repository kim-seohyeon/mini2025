<!-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
빌려요


<c:if test="${!empty auth }">
<ul>
	<li><a href="userDetail.mini">내 정보</a></li>	
	<li><a href="logout.login">로그아웃</a></li>
	<li><a href="itemList.mini">대여 상품 목록</a>
	<li><a href="cartList.mini">장바구니</a>
	
	<li><a href="renterList.mini">대여자 목록</a>
	<li><a href="ownerList.mini">빌린 물건 목록</a>	
	
</ul>
</c:if>


<c:if test="${empty auth }">
<form action="login.login" method="post">
<table border="1" align="center">
	<tr>
		<td colspan="2"> 로그인 유지 |  아이디 저장</td>
	</tr>
	
	<tr>
		<td>
			<input type="text" placeholder="아이디" name="userId" />
						<span style="color:red">${idErr }</span>
			
		</td>
		<td rowspan="2"><input type="submit" value="로그인"/></td></tr>
	<tr>
		<td><input type="password" placeholder="8~12자리 비밀번호" name="userPw"/>
				<span style="color:red">${pwErr }</span></td></tr>
	
	<tr>
		<td colspan="2">아이디 / 비밀번호 찾기 | <a href="userAgree.mini">회원가입</a></td></tr>
</table>
</form>
</c:if>

<table width=800 align="center">
	<tr>
		
		<c:forEach items="${list }" var="dto" varStatus="idx">
			<td>
				<a href="detailView.mini?itemId=${dto.itemId }">
					<img src="item/upload/${dto.itemMainStoreImage }" width=300 height=150/><br/>
						${dto.itemName } <br/>
						 ${dto.itemPrice }<br/>
				</a>				
			</td>
			<c:if test="${idx.count % 3 == 0 }"></tr><tr></c:if>
		
		</c:forEach>
		
	</tr>
</table>
</body>
</html>
 -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RentLink</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
        text-align: center;
    }
    ul {
        list-style-type: none;
        padding: 0;
        margin: 20px 0;
    }
    ul li {
        display: inline;
        margin-right: 15px;
    }
    ul li a {
        text-decoration: none;
        padding: 10px 15px;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
    }
    ul li a:hover {
        background-color: #0056b3;
    }
    table {
        background-color: white;
        border-collapse: collapse;
        margin: auto;
        width: 80%;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    td {
        padding: 10px;
        text-align: center;
    }
    form {
        background: white;
        padding: 20px;
        display: inline-block;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    input[type="text"], input[type="password"] {
        width: 200px;
        padding: 8px;
        margin: 5px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    input[type="submit"] {
        background-color: #28a745;
        color: white;
        border: none;
        padding: 10px 15px;
        cursor: pointer;
        border-radius: 5px;
    }
    input[type="submit"]:hover {
        background-color: #218838;
    }
    .item-list img {
        border-radius: 10px;
        transition: transform 0.3s;
    }
    .item-list img:hover {
        transform: scale(1.05);
    }
</style>
</head>
<body>
<h1>RentLink</h1>

<c:if test="${!empty auth }">
<ul>
    <li><a href="userDetail.mini">내 정보</a></li>
    <li><a href="logout.login">로그아웃</a></li>
    <li><a href="itemList.mini">대여 상품 목록</a></li>
    <li><a href="cartList.mini">장바구니</a></li>
    <li><a href="renterList.mini">대여자 목록</a></li>
    <li><a href="ownerList.mini">빌린 물건 목록</a></li>
</ul>
</c:if>

<c:if test="${empty auth }">
<form action="login.login" method="post">
    <table border="0">
        <tr>
            <td colspan="2"> 로그인 유지 | 아이디 저장</td>
        </tr>
        <tr>
            <td>
                <input type="text" placeholder="아이디" name="userId" />
                <span style="color:red">${idErr }</span>
            </td>
            <td rowspan="2">
                <input type="submit" value="로그인"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="password" placeholder="8~12자리 비밀번호" name="userPw"/>
                <span style="color:red">${pwErr }</span>
            </td>
        </tr>
        <tr>
            <td colspan="2">아이디 / 비밀번호 찾기 | <a href="userAgree.mini">회원가입</a></td>
        </tr>
    </table>
</form>
</c:if>

<table class="item-list">
    <tr>
        <c:forEach items="${list }" var="dto" varStatus="idx">
            <td>
                <a href="detailView.mini?itemId=${dto.itemId }">
                    <img src="item/upload/${dto.itemMainStoreImage }" width="300" height="150"/><br/>
                    <strong>${dto.itemName }</strong><br/>
                    <span style="color: #28a745; font-weight: bold;">${dto.itemPrice }</span><br/>
                </a>
            </td>
            <c:if test="${idx.count % 3 == 0 }"></tr><tr></c:if>
        </c:forEach>
    </tr>
</table>
</body>
</html>
 
 
 