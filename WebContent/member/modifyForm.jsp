<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="manager.*"%>

<%
	MemberService memberservice = new MemberService(new MemberDao());
	int num = Integer.parseInt(request.getParameter("num"));
	MemberVo vo = memberservice.read(num);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<h3>회원 수정하기</h3>
<form method="post" action="<%= request.getContextPath() %>/member/modify.jsp">
	<input type="hidden" name="num" value="<%= vo.getNum() %>">
	<input type="text" name="memberId" value="<%= vo.getMemberId() %>" placeholder="아이디" disabled="disabled"><br>
	<input type="password" name="memberPwOld" value="" placeholder="기존 비밀번호"><br>
	<input type="password" name="memberPwNew" value="" placeholder="새로운 비밀번호"><br>
	<input type="text" name="nickName" value="<%= vo.getNickname() %>" placeholder="닉네임"><br>
	<input type="submit" value="수정">
</form>
</body>
</html>