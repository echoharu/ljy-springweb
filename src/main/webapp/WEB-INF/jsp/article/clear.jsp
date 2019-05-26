<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContet.request.contextPath }/" />
<title>글 수정</title>
</head>
<body>
	<p> ${param.title } 글을 수정했습니다.</p>
	<p>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</p>
</body>
</html>