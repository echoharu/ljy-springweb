<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!-- 
게시글 목록
-->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글 목록</title>
</head>
<body>
	<h2>글 목록</h2>
		<p>
			<a href="./app/article/Addarticle">글쓰기</a>
	</p>
	<p>전체 ${totalCount }건</p>
	<form action="./app//article/articles">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>이름</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td><a href = "./app/article/view?articleId=${article.articleId }">${article.articleId }</a></td>
					<td>${article.title }</td>
					<td>${article.name }</td>
					<td>${article.cdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>