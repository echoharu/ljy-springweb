<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
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
		<a href="./app/article/list">글목록</a>
	
			<a href="./app/article/delete?articleId=${article.articleId }"
				onclick="return confirmDelete();">글삭제</a>
	</p>
	<hr />
	<p>
		<span>${letter.letterId }</span> | 
	</p>
	<p>
		<span>${letter.senderId }</span> | <span>${letter.senderName }</span>
	</p>
	<p>
		<span style="font-weight: bold;">${letter.title }</span> | <span>${letter.content }</span>
	</p>
	<p>
		<span>${letter.receiverId }</span> | <span>${letter.receiverName }</span>
	</p>
	<p>
		<span>${letter.cdate }</span>
	</p>
</body>
</html>