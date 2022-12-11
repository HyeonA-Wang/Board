<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글 등록</title>
	</head>
	<body>
		<h1>글 등록</h1>
		<a href="login.do">Log-out</a>
		<hr />
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="yellow" width="70">제목</td>
					<td align="left">
						<input type="text" name="title"" />
					</td>
				</tr>
				<tr>
					<td bgcolor="yellow">작성자</td>
					<td align="left"><input type="text" name="writer" /></td>
				</tr>
				<tr>
					<td bgcolor="yellow">내용</td>
					<td align="left">
						<textarea name="content" rows="10" cols="40"></textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="yellow">첨부파일</td>
					<td align="left"><input type="file" name="uploadFile" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 등록" />
					</td>
				</tr>
				
			</table>
		</form>
		<hr />
		<a href="getBoardList.do">글 목록</a>
	</body>
</html>