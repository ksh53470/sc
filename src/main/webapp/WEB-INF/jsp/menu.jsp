<%--
  Created by IntelliJ IDEA.
  User: 53470
  Date: 2022-09-02
  Time: 오후 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<head>
 <title>제목입니다.</title>
 <style>
  #title {
   font-size: 500%;
   top:50%;
   display: flex;
   justify-content: center;
   align-items: center;
   margin: auto;
   padding-bottom: 50px;
  }
  a{
   display: flex;
   justify-content: center;
   align-items: center;
   padding-top: 10px;
   font-size: 130%;
  }
  #modal.modal-overlay {
   width: 100%;
   height: 100%;
   position: absolute;
   left: 0;
   top: 0;
   display: none;
   flex-direction: column;
   align-items: center;
   justify-content: center;
   background: rgba(255, 255, 255, 0.25);
   box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
   backdrop-filter: blur(1.5px);
   -webkit-backdrop-filter: blur(1.5px);
   border-radius: 10px;
   border: 1px solid rgba(255, 255, 255, 0.18);
  }
  #modal .modal-window {
   background: rgba( 69, 139, 197, 0.70 );
   box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
   backdrop-filter: blur( 13.5px );
   -webkit-backdrop-filter: blur( 13.5px );
   border-radius: 10px;
   border: 1px solid rgba( 255, 255, 255, 0.18 );
   width: 400px;
   height: 500px;
   position: relative;
   top: -100px;
   padding: 10px;
  }
  #modal .title {
   padding-left: 10px;
   display: inline;
   text-shadow: 1px 1px 2px gray;
   color: white;

  }
  #modal .title h2 {
   display: inline;
  }
  #modal .close-area {
   display: inline;
   float: right;
   padding-right: 10px;
   cursor: pointer;
   text-shadow: 1px 1px 2px gray;
   color: white;
  }

  #modal .content {
   margin-top: 20px;
   padding: 0px 10px;
   text-shadow: 1px 1px 2px gray;
   color: white;
  }
 </style>
 <script>
  window.onload = function () {
   const modal = document.getElementById("modal")

   function modalOn() {
    modal.style.display = "flex"
   }

   function isModalOn() {
    return modal.style.display === "flex"
   }

   function modalOff() {
    modal.style.display = "none"
   }
/*   function check(){
    let idcheck=';
    if(idcheck!=null) {
     btnModal.style.display = "none";
    }
   }*/
   const btnModal = document.getElementById("btn-modal")
   btnModal.addEventListener("click", e => {
    modalOn()
   })

   const closeBtn = modal.querySelector(".close-area")
   closeBtn.addEventListener("click", e => {
    modalOff()
   })
   modal.addEventListener("click", e => {
    const evTarget = e.target
    if (evTarget.classList.contains("modal-overlay")) {
     modalOff()
    }
   })
   window.addEventListener("keyup", e => {
    if (isModalOn() && e.key === "Escape") {
     modalOff()
    }
   })
  }
 </script>
</head>
<body>
<div id="title">
 Welcome!
</div>
<div id="container">

</div>
<div id="modal" class="modal-overlay">
 <div class="modal-window">
  <div class="title">
   <h2>로그인</h2>
  </div>
  <div class="close-area">X</div>
  <div class="content">
   <form action="login.do">
    ID : <input type="text" placeholder="아이디를 입력하세요" name="id"><br/>
    PW : <input type="text" placeholder="비밀번호를 입력하세요" name="pw"><br/>
    <input type="submit" value="확인">
    <input type="reset" value="취소">
   </form>
  </div>

 </div>
</div>

<a href="#" id="btn-modal">로그인</a>
<a href="<%=request.getContextPath()%>/joinForm.html">회원가입하기</a><br/>
<a>비밀번호 찾기</a><br/>
<a>오늘 날씨</a><br/>
<a>게임</a><br/>
</body>
</html>
