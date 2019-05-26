<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!-- 
글 수정
-->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>해당 글 수정</title>
</head>
<body>	
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<a href="./app/article/list">[게시판 목록]</a>
	<form action="./app/article/clear" method="post">
		<c:if test="${param.mode=='FAILURE' }">
			<p style="color: red;">제목이 같습니다.</p>
		</c:if>
		
		<p>제목 :</p>
		<p>
			<input type="text" name="title" maxlength="100" style="width: 100%;" 
			value="${article.title }"required autofocus/>
		</p>
		<p>내용 :</p>
		<p>
			<input name="content" style="width: 100%; height: 200px;" 
			value="${article.content }"required autofocus>
		</p>
		<p>
			<button type="submit">수정</button>
		</p>
		</form>
</body>
</head>
</html>