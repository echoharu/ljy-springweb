<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!-- 
게시글 조회
-->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글 조회</title>
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("삭제하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>	
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>글 보기</h2>
	<p>
		<a href="./app/article/list">[게시글 목록]</a>
		<c:if test="${article.userId == sessionScope.MEMBER.memberId }">
			<a href="./app/article/updateForm?articleId=${article.articleId }">글수정</a>
			<a href="./app/article/delete?articleId=${article.articleId }"
				onclick="return confirmDelete();">글삭제</a>
		</c:if>
	</p>
	<p>
		<span>번호 : ${article.articleId }</span> 
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
	
</body>
</head>
</html>