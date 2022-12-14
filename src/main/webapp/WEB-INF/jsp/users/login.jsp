<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title><spring:message code="message.user.login.title" /></title>
	</head>
	<body>
		<h1><spring:message code="message.user.login.title" /></h1>
		<a href="login.do?lang=en"><spring:message code="message.user.login.language.en" /></a>&nbsp;&nbsp;
		<a href="login.do?lang=ko"><spring:message code="message.user.login.language.ko" /></a>&nbsp;&nbsp;
		<a href="login.do?lang=jp"><spring:message code="message.user.login.language.jp" /></a>&nbsp;&nbsp;
		<hr />
		<form action="loginProcess.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange"><spring:message code="message.user.login.id" /></td>
					<td><input type="text" name="id" value="${vo.id}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange"><spring:message code="message.user.login.password" /></td>
					<td>
						<input type="password" name="password" value="${vo.password}"/>
						<input type="hidden" name="name" value="USB"/>
						<input type="hidden" name="role" value="!hi?" />
					</td>
					
				</tr>
				<tr>
					<td colspan="2" align="center"> <input type="submit" value="<spring:message code="message.user.login.loginBtn" />" /></td>
				</tr>
			</table>
		</form>
	</body>
</html>