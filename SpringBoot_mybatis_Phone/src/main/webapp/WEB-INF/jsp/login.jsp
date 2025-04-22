<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            background: linear-gradient(to right, #e3f2fd, #ffffff);
        }
        .full-wrapper {
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding: 40px;
        }
        .login-box {
            max-width: 600px;
            width: 100%;
            margin: auto;
            background: #fff;
            padding: 40px;
            border-radius: 1.5rem;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }
        .login-box h1 {
            font-size: 2.2rem;
            font-weight: bold;
            margin-bottom: 1.5rem;
            color: #0d6efd;
            text-align: center;
        }
        .btn-primary {
            width: 100%;
            font-size: 1.1rem;
            padding: 0.75rem;
            border-radius: 0.75rem;
        }
    </style>
</head>
<body>
<div class="container-fluid full-wrapper">
    <div class="login-box">
        <h1>🔐 로그인</h1>
        <form novalidate>
            <div class="mb-3">
                <label for="userEmail" class="form-label">이메일</label>
                <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="이메일을 입력해주세요." value="ureca@naver.com" required>
            </div>
            <div class="mb-3">
                <label for="userPassword" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="비밀번호를 입력해주세요." value="ureca1234!" required>
            </div>
            <button type="button" id="btnLogin" class="btn btn-primary">로그인</button>
        </form>
    </div>
</div>

<script>
    window.onload = function () {
        document.querySelector("#btnLogin").onclick = function () {
            const email = document.querySelector("#userEmail").value.trim();
            const pw = document.querySelector("#userPassword").value.trim();
            if (!email || !pw) {
                alert("이메일과 비밀번호를 모두 입력해주세요.");
                return;
            }
            login();
        }
    }

    async function login() {
        const userEmail = document.querySelector("#userEmail").value;
        const userPassword = document.querySelector("#userPassword").value;

        const urlParams = new URLSearchParams({ userEmail, userPassword });

        const response = await fetch("/auth/login", {
            method: "POST",
            body: urlParams
        });
        const data = await response.json();

        if (data.result === "success") {
            window.location.href = "/pages/phone";
        } else {
            alert("이메일 또는 비밀번호가 올바르지 않습니다.");
        }
    }
</script>
</body>
</html>
