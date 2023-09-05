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
</style>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous"
/>
</head>
<body>
    <div class="container">
        <h1>회원가입</h1>
        <form action="/member/insert" method="post">
            <label for="id">아이디 : </label>
            <input type="text" name="id" id="id" class="form-control"><br>
            <label for="password">비밀번호 : </label>
            <input type="password" name="password" id="password" class="form-control"><br>
            <label for="name">이름 : </label>
            <input type="text" name="name" id="name" class="form-control"><br>
            <label for="address">주소 : </label>
            <input type="text" name="address" id="address" class="form-control"><br>
            <button type="submit" class="btn btn-primary">회원가입</button>
        </form>
    </div>
</body>
</html>