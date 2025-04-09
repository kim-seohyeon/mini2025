<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userModify.jsp</title>
</head>
<body>
내 정보 수정하기
<form action="userModify.mini" method="post">
회원 아이디 : <input type="text" name="userId" value="${dto.userId }" readonly="readonly" /><br/>
회원이름 : <input type="text" name="userName" value="${dto.userName }"/><br/>
회원 연락처 : <input type="tel" name="userPhone" value="${dto.userPhone }"/><br/>
회원 이메일 : <input type="email" name="userEmail" value="${dto.userEmail }"/><br/>
회원 생년월일 : <input type="date" name="userBirth" value="${dto.userBirth }"/><br/>
<input type="submit" value="수정 완료"/>
</form>
</body>
</html>
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
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
    h1 {
        color: #333;
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    label {
        font-weight: bold;
        margin-top: 10px;
    }
    input[type="text"], input[type="tel"], input[type="email"], input[type="date"] {
        width: 80%;
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    input[readonly] {
        background-color: #e9ecef;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 15px;
        cursor: pointer;
        border-radius: 5px;
        margin-top: 10px;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h1>내 정보 수정하기</h1>
    <form action="userModify.mini" method="post">
        <label>회원 아이디:</label>
        <input type="text" name="userId" value="${dto.userId }" readonly="readonly" />
        <label>회원 이름:</label>
        <input type="text" name="userName" value="${dto.userName }"/>
        <label>회원 연락처:</label>
        <input type="tel" name="userPhone" value="${dto.userPhone }"/>
        <label>회원 이메일:</label>
        <input type="email" name="userEmail" value="${dto.userEmail }"/>
        <label>회원 생년월일:</label>
        <input type="date" name="userBirth" value="${dto.userBirth }"/>
        <input type="submit" value="수정 완료"/>
    </form>
</div>
</body>
</html>
