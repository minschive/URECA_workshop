<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
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
        .register-box {
            max-width: 600px;
            width: 100%;
            margin: auto;
            background: #fff;
            padding: 40px;
            border-radius: 1.5rem;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }
        .register-box h1 {
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
    <div class="register-box">
        <h1>📝 회원 가입</h1>
        <form novalidate>
            <div class="mb-3">
                <label for="userName" class="form-label">이름</label>
                <input type="text" class="form-control" id="userName" name="userName" placeholder="홍길동">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback">이름은 2글자 이상이어야 합니다.</div>
            </div>
            <div class="mb-3">
                <label for="userPassword" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="비밀번호 입력">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback">특수문자, 알파벳, 숫자를 각각 1개 이상 포함해야 합니다.</div>
            </div>
            <div class="mb-3">
                <label for="userPassword2" class="form-label">비밀번호 확인</label>
                <input type="password" class="form-control" id="userPassword2" name="userPassword2" placeholder="비밀번호 재입력">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
            </div>
            <div class="mb-3">
                <label for="userEmail" class="form-label">이메일</label>
                <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="hong@gildong.com">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback">올바른 이메일 형식이 아닙니다.</div>
            </div>
            <button type="button" id="btnRegister" class="btn btn-primary">회원 가입</button>
        </form>
    </div>
</div>

<script>
    window.onload = function(){
        document.querySelector("#btnRegister").onclick = function(){
            if( document.querySelectorAll("form .is-invalid").length > 0 ) {
                alert("입력이 올바르지 않습니다.");
                return;
            }
            register();
        }

        document.querySelector("#userName").onblur = function(){
            validateInput(this, validateUserName);
        }
        document.querySelector("#userPassword").onblur = function(){
            validateInput(this, validatePassword);
        }
        document.querySelector("#userPassword2").onblur = function(){
            validateInput(this, validatePassword2);
        }
        document.querySelector("#userEmail").onblur = function(){
            validateInput(this, validateUserEmail);
        }
    }

    function validateInput(input, validator) {
        if (validator(input.value)) {
            input.classList.remove("is-invalid");
            input.classList.add("is-valid");
        } else {
            input.classList.remove("is-valid");
            input.classList.add("is-invalid");
        }
    }

    function validateUserName(name) {
        return name.length >= 2;
    }

    function validatePassword(pw) {
        let hasLetter = /[a-zA-Z]/.test(pw);
        let hasNumber = /[0-9]/.test(pw);
        let hasSpecial = /[~!@#$%^&*()_+|<>?:{}]/.test(pw);
        return hasLetter && hasNumber && hasSpecial;
    }

    function validatePassword2(pw2) {
        return pw2 === document.querySelector("#userPassword").value;
    }

    function validateUserEmail(email) {
        let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        return regexp.test(email);
    }

    async function register() {
        let userName = document.querySelector("#userName").value;
        let userPassword = document.querySelector("#userPassword").value;
        let userEmail = document.querySelector("#userEmail").value;

        let urlParams = new URLSearchParams({
            userName,
            userPassword,
            userEmail
        });

        let response = await fetch("/user/register", {
            method: "POST",
            body: urlParams
        });

        let data = await response.json();

        if( data.result === "success" ) {
            alert("회원가입에 성공했습니다.");
            window.location.href = "/pages/login";
        } else {
            alert("회원가입 도중 문제가 발생했습니다.");
        }
    }
</script>
</body>
</html>
