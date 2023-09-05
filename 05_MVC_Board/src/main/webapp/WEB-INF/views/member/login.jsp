<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	body {
        padding: 20px;
    }
    
    h1 {
        text-align: center;
    }

    .container {
        display: flex;
        justify-content: center;
    }
</style>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous"
/>
</head>
<body>
    <h1>로그인</h1>
    <div class="container">
        <form action="/login" method="post">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <label for="username">아이디 : </label>
            <input type="text" name="username" id="username" class="form-control"><br>
            <label for="password">비밀번호 : </label>
            <input type="password" name="password" id="password" class="form-control"><br>
            <button type="submit" class="btn btn-primary">로그인</button>
            <a href="/member/register" class="btn btn-primary">회원가입</a>
        </form>
    </div>
</body>
</html>