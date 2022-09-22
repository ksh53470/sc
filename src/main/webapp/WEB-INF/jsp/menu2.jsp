<%@ page import="kr.co.seoulit.member.to.MemberBean" %><%--
  Created by IntelliJ IDEA.
  User: 53470
  Date: 2022-09-02
  Time: 오후 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
  #deletebtn{
    display: none;
  }
  </style>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<head>
  <title>제목입니다.</title>
   <script type="text/javascript">
    window.onload = function () {

    }
    $(document).ready(function (){
      $("#listbutton").click(getmemberList);
      $("#deletebtn").click(deletemember);


    });

    function getmemberList(){
      $("#deletebtn").show();
      $.ajax({
        url:"<%=request.getContextPath()%>/member/ajaxlist.do",
        dataType:"json",
        success:function (obj) {
          const array = ["<ol>"];
          obj.memberlist.forEach(member => {
            array.push("<a href='#' id='detailmember' onclick='detailmember(this)' >");
            array.push("<li>");
            array.push("<input type=radio name=selected value="+member.id+" />");
            array.push(member.id);
            array.push("</li>");
            array.push("</a>");
            }
          )
          array.push("</ol>");
          $("#memberListContainer").html(array.join(""))
        }
      });
    };
    function deletemember(){
      var a = $('input[name=selected]:checked').val();
      console.log(a);
    $.ajax({
        url:"<%=request.getContextPath()%>/member/delete.do",

        data : { "senddata" : a },
        dataType:"json",
        success:function (data) {
          if(data.errorCode<0) {
            alert("내부서버 오류");

          }else {
            alert("삭제되었습니다.");
          }
          location.reload();
        }
      });
    }
    function detailmember(member){
      var dmember = $(member).text();
      console.log("연결됨");
      console.log(dmember);
      $.ajax({
        url:"<%=request.getContextPath()%>/member/ajaxdetail.do",
        data : {"id" : dmember },
        dataType:"json",
        success:function (obj) {
          console.log(obj.memberInfo);

          /*const array = ["<ol>"];
          obj.memberlist.forEach(member =>
              array.push("<li>" + member.id + "</li>")
          )
          array.push("</ol>");*/

          $(member).after(obj.memberInfo.pw);

        }
      });
    }

  </script>
</head>
<body>
<div id="title">
  Welcome!
</div>
<div id="container">

</div>
<script>
  <%
  String id = (String)session.getAttribute("id");
  %>
</script>
<a><%=id%>님 안녕하세요!</a>
<a href="menu.html" id="btn-modal">로그아웃</a>
<a href="modify.html">회원 정보 수정하기</a>
<a href="#" id="listbutton">회원 리스트 보기</a>
<div id="memberListContainer"></div>
<a><button id="deletebtn">삭제</button></a>
<a>오늘 날씨</a><br/>
<a>게임</a><br/>

</body>
</html>
