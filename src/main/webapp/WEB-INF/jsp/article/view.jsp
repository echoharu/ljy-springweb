<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!-- 
게시글 조회
-->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글 조회</title>
</head>
<body>	
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<a href="./app/article/list">[게시글 목록]</a>
	<table>
		<thead>
			<tr>				
				<td>제목</td>
				<td>내용</td>
				<td>학번</td>
				<td>이름</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
				<tr>					
					<td>${article.title }</td>
					<td>${article.content }</td>
					<td>${article.userId }</td>
					<td>${article.name }</td>
					<td>${article.cdate }</td>
				</tr>
		</tbody>
	</table>
</body>
</head>
</html>