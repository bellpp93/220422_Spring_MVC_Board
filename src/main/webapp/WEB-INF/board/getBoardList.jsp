<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>

<!-- JSTL 적용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoardList.jsp 페이지</title>
<style>
	#div_box {
		position:absolute;
		top:10%;
		left:20%;
	}
</style>
</head>
<body>
	<div id="div_box">
		<h1>전체 게시글 목록 보기</h1>
		<p>총 게시글: ${boardList.size()}건</p>
		<h3>${IdKey}님 환영합니다.&nbsp;&nbsp;&nbsp;<a href="logout.do">로그아웃</a></h3>
		<form name="listForm" method="POST" action="getBoardList.do">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="left">
						<select name="searchCondition">
							<option value="TITLE">제목
							<option value="WRITER">작성자
						</select>
						<input type="text" name="searchKeyword"/>
						<input type="submit" name="검색"/>
					</td>
				</tr>
			</table>
		</form>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">작성일자</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td align="center">${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td align="center">${board.writer}</td>
					<td align="center">${board.regdate}</td>
					<td align="center">${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="insertBoard.jsp">새 게시글 등록</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">전체 게시글 목록보기</a>
	</div>
</body>
</html>