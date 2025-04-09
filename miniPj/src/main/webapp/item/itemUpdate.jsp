<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemUpdate.jsp</title>
</head>

<body>
대여 상품 수정페이지
<form action="itemModify.mini" method="POST">
<table border = "1" width ="600" align="center">
	<tr><th width="100">상품번호</th>
		<td><input type="text" name="itemId" value="${dto.itemId }" readonly="readonly" />번호자동부여</td></tr>
	<tr><th>상품명</th>
		<td><input type="text" name="itemName" value="${dto.itemName }"/></td></tr>
	<tr><th>상품 대여료</th>
		<td><input type="number" name="itemPrice" value="${dto.itemPrice }"/></td></tr>
	<tr><th>상품설명</th>
		<td><textarea rows="10" cols="50" name="itemContents">${dto.itemContents }</textarea></td></tr>
 	
	<tr><th colspan="2">
		<input type="submit" value="수정 완료" />
		<a href = "itemList.mini">상품목록</a></th>
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
<title>대여 상품 수정</title>
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
        width: 50%;
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
        text-align: left;
    }
    th {
        background-color: #007bff;
        color: white;
    }
    input, textarea {
        width: 95%;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .button-container {
        margin-top: 20px;
    }
    .button-container input, .button-container a {
        padding: 10px 20px;
        margin: 5px;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        cursor: pointer;
    }
    .btn-primary {
        background-color: #007bff;
        color: white;
    }
    .btn-secondary {
        background-color: #6c757d;
        color: white;
    }
</style>
</head>
<body>
<div class="container">
    <h1>대여 상품 수정</h1>
    <form action="itemModify.mini" method="POST">
        <table>
            <tr>
                <th width="100">상품번호</th>
                <td><input type="text" name="itemId" value="${dto.itemId }" readonly="readonly" /> 자동 부여</td>
            </tr>
            <tr>
                <th>상품명</th>
                <td><input type="text" name="itemName" value="${dto.itemName }"/></td>
            </tr>
            <tr>
                <th>상품 대여료</th>
                <td><input type="number" name="itemPrice" value="${dto.itemPrice }"/></td>
            </tr>
            <tr>
                <th>상품설명</th>
                <td><textarea rows="5" name="itemContents">${dto.itemContents }</textarea></td>
            </tr>
        </table>
        <div class="button-container">
            <input type="submit" value="수정 완료" class="btn-primary" />
            <a href="itemList.mini" class="btn-secondary">상품 목록</a>
        </div>
    </form>
</div>
</body>
</html>
