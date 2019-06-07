<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>편지쓰기</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>편지 등록</h2>
	<p>
		<a href="./app/letter/listSent">보낸 목록</a>
	</p>
	<form action="./app/letter/add" method="post">
	
	
		<p>제목 :</p>
		<p>
			<input type="text" name="title" maxlength="100" style="width: 50%;" required>
		</p>
		<p>내용 :</p>
		<p>
			<textarea name="content" style="width: 100%; height: 200px;" required></textarea>
		</p>
		<p>상대방 아이디 :</p>
		<p>
			 <input type="text" name="receiverId" value="${param.receiverId }"readonly />
		</p>
		<p>상대방 이름 :</p>
		<p>
			<input type="text" name="receiverName" value="${param.receiverName }" readonly />
		</p>
		<p>
			<button type="submit">쓰기</button>
		</p>
	</form>
</body>
</html>