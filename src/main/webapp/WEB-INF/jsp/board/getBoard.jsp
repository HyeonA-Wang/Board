<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글 상세</title>
	</head>
	<body>
		<h1>글 상세</h1>
		<a href="login.do" method="get">Log-out</a>
		<hr />
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="${board.seq}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="yellow" width="70">제목</td>
					<td align="left">
						<input type="text" name="title" value="${board.title}" />
					</td>
				</tr>
				<tr>
					<td bgcolor="yellow">작성자</td>
					<td align="left">${board.writer}</td>
				</tr>
				<tr>
					<td bgcolor="yellow">내용</td>
					<td align="left">
						<textarea name="content" rows="10" cols=""40>${board.content}</textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="yellow">등록일</td>
					<td align="left">${board.regDate}</td>
				</tr>
				<tr>
					<td bgcolor="yellow">조회수</td>
					<td align="left">${board.cnt}</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정" />
					</td>
				</tr>
			</table>
		</form>
		<hr />
		<a href="regBoard.do">글 등록</a>
		<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>
		<a href="getBoardList.do">글 목록</a>
	</body>
</html>