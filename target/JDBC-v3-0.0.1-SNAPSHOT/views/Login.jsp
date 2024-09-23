<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Đăng nhập"></dec:title></title>
<link rel="stylesheet" href="<c:url value="/template/Login/style.css"/>" />
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">

			<!-- Tabs Titles -->
			<div>
				<h2 class="mb-3">Login</h2>
				<h6 class="mb-3">Welcom to system</h6>
			</div>
			<c:if test="${not empty message}">
				<div class="alert alert-${alert} m-2" role="alert">
						${message}
				</div>
<%--				<div class="alert alert-success m-2" role="alert">--%>
<%--									Login Success--%>
<%--								</div>--%>
			</c:if>

			<!-- Login Form -->
			<form action="<c:url value='/login'/>" method="post" id="formlogin">
				<input type="text" id="userName" class="fadeIn second" name="userName"
					placeholder="userName"> 
				<input type="password" id="password"
					class="fadeIn third" name="password" placeholder="password"> 
				<input
					type="submit" class="fadeIn fourth" value="Log In">
				<input type="hidden" id="action" name="action" value="login">
			</form>

		</div>
	</div>
</body>
</html>