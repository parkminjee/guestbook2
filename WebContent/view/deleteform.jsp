<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook2/gb" method="post" >
	<input type='hidden' name="no" value="<%=Integer.parseInt(request.getParameter("no")) %>">
	<input type='hidden' name="a" value="delete">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/guestbook2/gb">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>