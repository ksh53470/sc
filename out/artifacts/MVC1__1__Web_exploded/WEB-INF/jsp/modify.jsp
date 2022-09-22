<%--
  Created by IntelliJ IDEA.
  User: 53470
  Date: 2022-09-06
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원정보수정</h1>
<script>
    <%
    String id = (String)session.getAttribute("id");
    %>
</script>

<form action="<%=request.getContextPath()%>/modify.do">
    <a><%=id%>님 정보를 변경하세요!</a><br/>
    비밀번호 : <input type="text" name="pw" /><br/>
    주소 : <input type="text" name="addr" /><br/>
    전화번호 : <input type="text" name="tel" /><br/>
    <input type="submit" value="수정" />
    <input type="reset" value="취소" />
</body>
</html>
