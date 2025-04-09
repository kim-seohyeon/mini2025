<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemForm.jsp</title>
</head>
<body>
대여 상품 등록하기 

<form action="itemRegist.mini" method="POST" enctype="multipart/form-data">
<table border = "1" width ="600" align="center">
	<tr><th width="100">상품번호</th>
		<td><input type="text" name="itemId" value="${itemId }" readonly="readonly" />번호자동부여</td></tr>
	<tr><th>상품명</th>
		<td><input type="text" name="itemName"/></td></tr>
	<tr><th>상품 대여료</th>
		<td><input type="number" name="itemPrice"/></td></tr>
	<tr><th>상품설명</th>
		<td><textarea rows="10" cols="50" name="itemContents"></textarea></td></tr>
	
	<tr><th>메인 이미지</th>
		<td><input type="file" name="itemMainImage" /></td></tr>
		
	<tr><th>상품설명이미지</th>
		<td><input type="file" name="image1" />
			<input type="file" name="image2" />
			<input type="file" name="image3" /></td>
	</tr>		
	
	<tr><th colspan="2"><input type="submit" value="대여상품등록" /></th></tr>
</table>	
</form>
</body>
</html>
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 상품 등록</title>
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
        text-align: left;
    }
    th {
        background-color: #007bff;
        color: white;
        text-align: center;
    }
    input, textarea, button {
        width: 95%;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="file"] {
        width: auto;
    }
    button {
        background-color: #28a745;
        color: white;
        font-weight: bold;
        cursor: pointer;
    }
    button:hover {
        background-color: #218838;
    }
</style>
</head>
<body>
<div class="container">
    <h1>대여 상품 등록</h1>
    <form action="itemRegist.mini" method="POST" enctype="multipart/form-data">
        <table>
            <tr><th>상품번호</th>
                <td><input type="text" name="itemId" value="${itemId }" readonly="readonly" /> 번호 자동 부여</td></tr>
            <tr><th>상품명</th>
                <td><input type="text" name="itemName" required/></td></tr>
            <tr><th>상품 대여료</th>
                <td><input type="number" name="itemPrice" required/></td></tr>
            <tr><th>상품설명</th>
                <td><textarea rows="5" name="itemContents" required></textarea></td></tr>
            <tr><th>메인 이미지</th>
                <td><input type="file" name="itemMainImage" required/></td></tr>
            <tr><th>상품설명이미지</th>
                <td>
                    <input type="file" name="image1" />
                    <input type="file" name="image2" />
                    <input type="file" name="image3" />
                </td>
            </tr>
            <tr><th colspan="2" style="text-align:center;"><button type="submit">대여 상품 등록</button></th></tr>
        </table>
    </form>
</div>
</body>
</html>
