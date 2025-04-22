<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>휴대폰 관리</title>
</head>
<body>
<h1>휴대폰 정보</h1>

<table>
    <thead>
        <tr><th>phoneId</th><th>brand</th><th>model</th><th>price</th><th>stock</th></tr>
    </thead>
    <tbody id="phoneTbody">
    </tbody>
</table>
<hr>
<form>
    <input type="text" name="phoneId" id="phoneId"></input><br>
    <input type="text" name="brand" id="brand"></input><br>
    <input type="text" name="model" id="model"></input><br>
    <input type="text" name="price" id="price"></input><br>
    <input type="text" name="stock" id="stock"></input><br>
</form>
<hr>
<button type="button" id="btnInsert">등록</button> <button type="button" id="btnUpdate">수정</button> <button type="button" id="btnDelete">삭제</button>

<script>
    window.onload = function(){
        listEmp();

        document.querySelector("#btnInsert").onclick = insertEmp;
        document.querySelector("#btnUpdate").onclick = updateEmp;
        document.querySelector("#btnDelete").onclick = deleteEmp;
    }

    async function listEmp(){

        let url = '/phone/list';
        try{
            let response = await fetch(url); // get 요청 json 포함 응답
            let data = await response.json(); // response 에서 json 꺼내서 javascript 객체로 변환

            makeListHtml(data); // javascript 객체를 이용해서 table 에 목록 구성

        }catch(error){
            console.log(error);
            alert('휴대폰 목록 처리 중 오류 발생!');
        }
    }

    <%-- ${}  --%>
    // 백틱 (`) : 두 백틱 사이의 멀티라인의 문자열을 허락
    // \${el.bookId} : 문자열 사이에 자바스크립트 객체의 값을 전달 => 1, 2, 3,
    // 위 2개 모두 문자열 연결 + 처리하는 불편 해소
    // \${} ?? <= // jsp el 충동 방지
    async function makeListHtml(list){
        console.log(list);

        let listHTML = ``;
        list.forEach( el => {

            listHTML +=
                `<tr style="cursor:pointer" data-employeeId=\${el.phoneId}>
                        <td>\${el.phoneId}</td>
                        <td>\${el.brand}</td>
                        <td>\${el.model}</td>
                        <td>\${el.price}</td>
                        <td>\${el.stock}</td>
                    </tr>`;

        } );

        document.querySelector("#phoneTbody").innerHTML = listHTML;

        document.querySelectorAll("#phoneTbody tr").forEach( el => {
            el.onclick = function(){
                let phoneId = this.getAttribute("data-phoneId");
                detailPhone(phoneId);
            }
        });
    }

    async function detailPhone(phoneId){
        let url = '/phone/detail/' + phoneId;  // path variable 에 대응
        try{
            let response = await fetch(url);
            let data = await response.json();
            console.log(data);

            document.querySelector("#phoneId").value = data.phoneId;
            document.querySelector("#brand").value = data.brand;
            document.querySelector("#model").value = data.model;
            document.querySelector("#price").value = data.price;
            document.querySelector("#stock").value = data.stock;

        } catch( error ){
            console.error( error );
            alert('휴대폰 상세 처리 중 오류 발생!');
        }
    }

    async function insertPhone(){
        let urlParams = new URLSearchParams({  // post 전송 방식 중 x-www-url-encoded 방식
            phoneId: document.querySelector("#phoneId").value,
            brand: document.querySelector("#brand").value,
            model: document.querySelector("#model").value,
            price: document.querySelector("#price").value,
            stock: document.querySelector("#stock").value
        });

        let fetchOptions = {
            method: "POST",
            body: urlParams,
        }

        let url = '/phone/insert';

        try{
            let response = await fetch(url, fetchOptions );
            let data = await response.json();

            console.log(data);

            if( data.result == "success" ){
                alert('휴대폰 등록!');
            }else {
                alert('휴대폰 등록 실패!');
            }

            listPhone();

        }catch( error ){
            console.error( error );
            alert('휴대폰 등록 처리 중 오류 발생!');
        }
    }

    async function updatePhone(){
        let urlParams = new URLSearchParams({
            phoneId: document.querySelector("#phoneId").value,
            brand: document.querySelector("#brand").value,
            model: document.querySelector("#model").value,
            price: document.querySelector("#price").value,
            stock: document.querySelector("#stock").value
        });

        let fetchOptions = {
            method: "POST",
            body: urlParams,
        }

        let url = '/phone/update';

        try{
            let response = await fetch(url, fetchOptions );
            let data = await response.json();

            console.log(data);

            if( data.result == "success" ){
                alert('휴대폰 수정!');
            }else {
                alert('휴대폰 수정 실패!');
            }

            listPhone();

        }catch( error ){
            console.error( error );
            alert('휴대폰 수정 처리 중 오류 발생!');
        }
    }

    async function deletePhone(){
        let phoneId = document.querySelector("#phoneId").value;
        let url = '/phone/delete/' + phoneId;
        try{
            let response = await fetch(url);
            let data = await response.json();
            console.log(data);

            if( data.result == "success" ){
                alert('휴대폰 삭제!');
            }else {
                alert('휴대폰 삭제 실패!');
            }

            listPhone();

        }catch( error ){
            console.error( error );
            alert('휴대폰 삭제 처리 중 오류 발생!');
        }
    }
</script>
</body>
</html>