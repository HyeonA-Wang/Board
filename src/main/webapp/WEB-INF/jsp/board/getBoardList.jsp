<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@
    taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"
%><%@
taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><spring:message code="message.board.list.mainTitle" /></title>
	</head>
	<body>
		<h1><spring:message code="message.board.list.search.condition.title" /></h1>
		<h3>${sessUser.name}(${sessUser.id}) <spring:message code="message.board.list.welcomeMsg" /><a href="login.do" method="get">Log-out</a></h3>
		<a href="getBoardList.do?lang=en"><spring:message code="message.user.login.language.en" /></a>&nbsp;&nbsp;
		<a href="getBoardList.do?lang=ko"><spring:message code="message.user.login.language.ko" /></a>&nbsp;&nbsp;
		<a href="getBoardList.do?lang=jp"><spring:message code="message.user.login.language.jp" /></a>&nbsp;&nbsp;
		
		<!-- 검색시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700px">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<c:forEach items="${conditionMap}" var="option">
								<option value="${option.value}">${option.key}</option>
							</c:forEach>
						</select>
						<input type="text" name="searchKeyword" />
						<input type="submit" value="<spring:message code="message.board.list.search.condition.btn" />" />
					</td>
				</tr>
			</table>
		</form>
		
		<table border="1" cellpadding="0" cellspacing="0" width="700px">
			<tr>
				<td bgcolor="yellow" width="100"><spring:message code="message.board.list.table.head.seq" /></td>
				<td bgcolor="yellow" width="200"><spring:message code="message.board.list.table.head.title" /></td>
				<td bgcolor="yellow" width="150"><spring:message code="message.board.list.table.head.writer" /></td>
				<td bgcolor="yellow" width="150"><spring:message code="message.board.list.table.head.regDate" /></td>
				<td bgcolor="yellow" width="100"><spring:message code="message.board.list.table.head.cnt" /></td>
			</tr>
			
			<!-- JSTL -->
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td>
					<a href="getBoard.do?seq=${board.seq}">
					${board.title}</a>
					</td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="regBoard.do"><spring:message code="message.board.list.link.insertBoard" /></a>
	</body>
</html>