<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글 삭제</title>
</head>
<body>	
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>글 삭제</h2>
	<p>
		<a href="./app/article/list">[게시글 목록]</a>
	</p>
	<p>
		${article.articleId } 글을 삭제했습니다.
	</p>
	
</body>
</head>
</html>