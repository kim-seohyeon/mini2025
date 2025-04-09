<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemDetail.jsp</title>
</head>
<body>

<table border=1 align="center" width="600">
<caption>${dto.itemName } 상품 상세보기</caption>
	<tr><th width="150" >상품번호</th>
		<td>${dto.itemId }</td></tr>
	<tr><th width="150" >상품명</th>
		<td>${dto.itemName }</td></tr>
	<tr><th>상품가격</th>
		<td>${dto.itemPrice }</td></tr>
	<tr><th>상품설명</th>
		<td>${dto.itemContents }</td></tr>
	<tr><th>등록한 회원</th>
		<td>${dto.userId }</td></tr>
	<tr><th>등록일</th>
		<td>${dto.itemRegist }</td></tr>
	<tr><th>수정일</th>
		<td>${dto.itemUpdateDate }</td></tr>	
	<tr><th>메인이미지</th>
		<td><img width="300" height="200" src="item/upload/${dto.itemMainStoreImage }"/></td></tr>	
	<tr>
		<th>상품 상세 이미지</th>
		<td>
			<c:forTokens items="${dto.itemDetailStoreImage }" delims="`" var="image">
				<img width="300" height="200" src="item/upload/${image }"/>
			</c:forTokens>
		</td>
	</tr>	
		
				
	<tr><th colspan="2">
		<a href="itemModify.mini?itemId=${dto.itemId }">상품수정</a> | 
		<a href="itemDelete.mini?itemId=${dto.itemId }">상품 삭제</a> | 
		<a href="itemList.mini">상품목록</a></th></tr>
</table>
</body>
</html>
 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<script src="https://code.jquery.com/jquery-1.8.1.js"></script>
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
    #wish {
        cursor: pointer;
    }
</style>
<script>
$(function(){
    $("#wish").click(function(){
        $.ajax({
            type : "post",
            url : "wishItem.mini",
            data : {"itemId" : "${dto.itemId}"},
            success : function(){
                let src = $("#wish").attr("src");
                $("#wish").attr("src", src === "images/hart1.jpg" ? "images/hart.png" : "images/hart1.jpg");
            },
            error:function(){
                alert("로그아웃 되었습니다. 다시 로그인 해 주세요");
                location.href="<c:url value='/' />";
            }
        });
    });
    
    $("#cartBtn").click(function(){
        $.ajax({
            type:"post",
            url:"cart.mini",
            data:{"itemId" : "${dto.itemId}", "cartQty":$("#cartQty").val()},
            success: function(){
                if(confirm("장바구니로 이동하시겠습니까?")) 
                    location.href="cartList.mini";
            },
            error:function(){
                alert("서버 오류");
            }
        });
    });
});
</script>
</head>
<body>
<div class="container">
    <h1>${dto.itemName }</h1>
    <table>
        <tr>
            <td rowspan="3" width="200"><img src="item/upload/${dto.itemMainStoreImage }" width="150" /></td>
            <td>${dto.itemName }</td>
        </tr>
        <tr>
            <td>수량: <input type="number" min="1" value="1" step="1" id="cartQty"></td>
        </tr>
        <tr>
            <td><fmt:formatNumber value="${dto.itemPrice }" pattern="###,###"/>원
                <button type="button" id="cartBtn">장바구니</button>
                <button type="button" id="rentalBtn">대여하기</button>
                <img src="images/hart1.jpg" width="30" id="wish"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="content">
                    ${dto.itemContents }<br/>
                    <c:forTokens items="${dto.itemDetailStoreImage }" delims="`" var="image">
                        <img src="item/upload/${image }" width="150"/><br/>
                    </c:forTokens>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
 
