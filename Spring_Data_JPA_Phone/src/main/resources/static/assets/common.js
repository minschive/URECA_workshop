window.onload =function () {
    initUI();

    // 로그아웃
    document.querySelector("#linkLogout").onclick = logout
}

function initUI() {
    // 로그인 상태를 확인 UI 처리
    let name = sessionStorage.getItem("name");

    if( name != null ){
        document.querySelector("#userName").innerHTML = name;
        document.querySelector("#userNameWrapper").style.display='inline';
        document.querySelector("#linkLogout").style.display='inline';

        document.querySelector("#linkSignup").style.display='none'
        document.querySelector("#linkLogin").style.display='none';

    }else{
        document.querySelector("#userName").innerHTML = '';
        document.querySelector("#userNameWrapper").style.display='none';
        document.querySelector("#linkLogout").style.display='none';

        document.querySelector("#linkSignup").style.display='inline'
        document.querySelector("#linkLogin").style.display='inline';

    }
}

async function logout() {
    // 로그아웃 확인 팝업
    const isConfirmed = confirm("로그아웃하시겠습니까?");
    if (!isConfirmed) return; // 취소 누르면 함수 종료

    // url
    let url = "/users/logout";

    let response = await fetch(url);
    let data = await response.json();

    console.log(data);
    if (data.result === 'success') {
        // user의 name, email 삭제
        sessionStorage.removeItem("name");
        sessionStorage.removeItem("email");

        // 전체 삭제도 가능
        // sessionStorage.clear();

        initUI();
    }

}