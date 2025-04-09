<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userDetail.jsp</title>
</head>
<body>

내 정보 상세보기<br/>
아이디 : ${dto.userId }<br/>
이름 : ${dto.userName }<br/>
연락처 :${dto.userPhone }<br/>
이메일 : ${dto.userEmail }<br/>
생년월일 : ${dto.userBirth }<br/>

<a href="userModify.mini?userId=${dto.userId }">내정보 수정</a><br/>
<a href="userDelete.mini?userId=${dto.userId }">회원탈퇴</a>
</body>
</html>
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 상세보기</title>
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
    .info {
        text-align: left;
        margin: 20px 0;
    }
    .info p {
        font-size: 16px;
        margin: 8px 0;
    }
    .actions a {
        display: inline-block;
        margin: 10px;
        padding: 10px 15px;
        text-decoration: none;
        border-radius: 5px;
        color: white;
        font-weight: bold;
    }
    .edit {
        background-color: #007bff;
    }
    .edit:hover {
        background-color: #0056b3;
    }
    .delete {
        background-color: #dc3545;
    }
    .delete:hover {
        background-color: #c82333;
    }
</style>
</head>
<body>
<div class="container">
    <h1>내 정보 상세보기</h1>
    <div class="info">
        <p><strong>아이디:</strong> ${dto.userId }</p>
        <p><strong>이름:</strong> ${dto.userName }</p>
        <p><strong>연락처:</strong> ${dto.userPhone }</p>
        <p><strong>이메일:</strong> ${dto.userEmail }</p>
        <p><strong>생년월일:</strong> ${dto.userBirth }</p>
    </div>
    <div class="actions">
        <a href="userModify.mini?userId=${dto.userId }" class="edit">내 정보 수정</a>
        <a href="userDelete.mini?userId=${dto.userId }" class="delete">회원 탈퇴</a>
    </div>
</div>
</body>
</html>
 