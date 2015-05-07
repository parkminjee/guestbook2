<%@ page import="com.sds.icto.guestbook.vo.guestbookVo" %>
<%@ page import="com.sds.icto.guestbook.dao.guestbookDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%
	guestbookDao dao = new guestbookDao();
	List<guestbookVo> list = dao.fetchList();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook2/gb" method="post">
	<input type='hidden' name="a" value="add">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="meg" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<%
		for( guestbookVo vo : list ) {
	%>
	<table width=510 border=1>
		<tr>
			<td><%=vo.getNo() %></td>
			<td><%=vo.getId() %></td>
			<td><%=vo.getDate() %></td>
			<td><a href="deleteform.jsp?no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMeg() %></td>
		</tr>
	</table>
	<br>
	<%
		}
	%>
</body>
</html>