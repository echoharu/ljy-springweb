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
	<h2>글 보기</h2>
	<p>
		<a href="./app/article/list">[게시글 목록]</a>
	</p>
	<p>
		<span>번호 : ${article.articleId }</span> | <span>학번 : ${article.userId }</span>
	</p>
	<p>
		<span style="font-weight:bold;">제목 : ${article.title }</span> 
	</p>
	<p>
		<span>내용 : ${article.contentHtml }</span>
	</p>
	<p>
		<span>등록일시 : ${article.cdate }</span>
	</p>
	<p>
		
		<a href="<c:url value="./app/article/update?articleId=${article.articleId }"/>">[수정]</a>

		<a href="<c:url value="./app/article/delete?articleId=${article.articleId }"/>">[삭제]</a>
		
	</p>
</body>
</head>
</html>