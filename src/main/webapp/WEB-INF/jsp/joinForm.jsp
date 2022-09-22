<%--
  Created by IntelliJ IDEA.
  User: 53470
  Date: 2022-09-05
  Time: 오후 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 가입하기</h1>
<form action="<%=request.getContextPath()%>/join.do">
  아이디 : <input type="text" name="id" /><br/>
  비밀번호 : <input type="text" name="pw" /><br/>
  주소 : <input type="text" name="addr" /><br/>
  전화번호 : <input type="text" name="tel" /><br/>
  <input type="submit" value="가입" />
  <input type="reset" value="취소" />
</form>
</body>
</html>
