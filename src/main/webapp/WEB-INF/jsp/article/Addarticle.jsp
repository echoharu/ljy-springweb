<!doctype html>
<!-- 
p.277 [리스트 11.9]  화면
 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글 입력</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<p>
		<a href="./app/articles">게시글 목록</a>
	</p>
	<form action="./app/article/success" method="post">
		<p>제목 :</p>
		<p>
			<input type="text" name="title" maxlength="100" style="width: 100%;"
				required>
		</p>
		<p>내용 :</p>
		<p>
			<textarea name="content" style="width: 100%; height: 200px;" required></textarea>
		</p>
		<button type="submit">등록</button>
	</form>
</body>
</html>