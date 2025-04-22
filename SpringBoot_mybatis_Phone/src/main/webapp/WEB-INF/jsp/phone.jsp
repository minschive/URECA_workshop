<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycom.myapp.user.dto.UserDto"%>
<%
    UserDto userDto = (UserDto) session.getAttribute("userDto");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>LG U+ URECA</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="/">URECA</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item mx-2">
                    <a class="nav-link" href="phone">상품</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="cus">고객</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="sale">판매 내역</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item d-flex align-items-center">
                    <%--                    <a class="nav-link" href="/pages/logout">Logout</a>--%>
                    <img src="/assets/img/user/<%=userDto.getUserProfileImage() %>" style="width:24px; height: 24px; border-radius: 50%; margin-right: 8px;">
                    <a class="nav-link" href="/auth/logout">Logout</a>
                </li>
            </ul>

        </div>
    </div>
</nav>

<div class="container mt-3">
    <div class="d-flex justify-content-between align-items-center">
        <h4 class="mt-3 mb-5">상품</h4>
        <div class="input-group" style="max-width: 300px;">
            <input id="inputSearchWord" type="text" class="form-control" placeholder="검색어">
            <button id="btnSearchWord" class="btn btn-primary" type="button">검색</button>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>제조사</th>
            <th>모델</th>
            <th>가격</th>
            <th>재고</th>
        </tr>
        </thead>
        <tbody id="phoneTbody">
        </tbody>
    </table>
</div>

    <script src="/assets/js/util.js"></script>
    <script>
        // logout 처리 방식 구분
        // #1. Javascript 를 이용한 비동기 처리
        //     Logout 이 클릭되면 이벤트핸들러에서 비동기로 logout 요청 ( 서버에서 로그아웃 처리 후 result:success 전달)
        //     페이지를 window.location.href 로 login 페이지로 이동
        // #2. a 의 href 에 page 요청 ( 서버에서 로그아웃 처리 후 바로 페이지를 이동 ) <= 2번으로 진행'

        let LIST_ROW_COUNT = 10; // limit 해당 변수
        let OFFSET = 0; // offset
        let SEARCH_WORD = ''; // searchWord
        let TOTAL_LIST_COUNT = 0; // 조회된 건수

        window.onload = function() {
            // 글 목록
            listPhone();

            // 검색어 처리
            document.querySelector("#btnSearchWord").onclick = function() {
                SEARCH_WORD = document.querySelector("#inputSearchWord").value;
                listPhone();
            }
        }

        async function listPhone() {
            let url = "/phones/list";
            let urlParams = "?limit=" + LIST_ROW_COUNT + "&offset=" + OFFSET + "&searchWord=" + SEARCH_WORD;
            let response = await fetch(url + urlParams);
            let data = await response.json();

            console.log(data);

            if(data.result == "success") {
                makeListHtml(data.list);
                TOTAL_LIST_COUNT = data.count;
            }
        }

        function makeListHtml(list){
            let listHTML = ``;

            list.forEach( el => {
                let phoneId = el.phoneId;
                let brand = el.brand;
                let model = el.model;
                let price = el.price;
                let stock = el.stock;

                listHTML += `<tr style="cursor:pointer" data-phoneId=\${phoneId}>
                            <td>\${phoneId}</td>
                            <td>\${brand}</td>
                            <td>\${model}</td>
                            <td>\${price}</td>
                            <td>\${stock}</td>
                        </tr>`;
            });

            document.querySelector("#phoneTbody").innerHTML = listHTML;

            document.querySelectorAll("#phoneTbody tr").forEach( el => {
                el.onclick = function(){
                    let phoneId = this.getAttribute("data-phoneId");
                    detailPhone(phoneId);
                }
            } );
        }

        async function detailPhone(phoneId) {
            alert(phoneId);
        }
    </script>
</body>
</html>