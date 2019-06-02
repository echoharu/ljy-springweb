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
	<h2>상세정보</h2>
	<p>
		<a href="./app/letter/listReceived">받은목록</a>
		<a href="./app/letter/listSent">보낸목록</a>

		<a href="./app/letter/delete?letterId=${letter.letterId }"
				onclick="return confirmDelete();">글삭제</a>

	</p>
	<hr />
	<p>
		<span>번호 : ${letter.letterId }</span>  
	</p>
	<p>
		<span>보낸사람 아이디 : ${letter.senderId }</span> | <span> 보낸사람 이름 : ${letter.senderName }</span>
	</p>
	<p>
		<span style="font-weight: bold;">제목 : ${letter.title }</span> | <span>내용 : ${letter.content }</span>
	</p>
	<p>
		<span>받는사람 아이디 : ${letter.receiverId }</span> | <span>받는사람 이름 : ${letter.receiverName }</span>
	</p>
	<p>
		<span>등록일시 : ${letter.cdate }</span>
	</p>
</body>
</html>