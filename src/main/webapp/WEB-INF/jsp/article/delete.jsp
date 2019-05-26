<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContet.request.contextPath }/" />
<title>글 삭제</title>
</head>
<body>
<h2>글 삭제</h2>
	<p>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</p>
	<p> ${article.articleID } 글을 삭제했습니다.</p>
	
</body>
</html>