<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Trang chủ" /></title>

    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />

	<link rel="stylesheet"
		href="<c:url value='/template/admin/tplnew/css/app.css' />" />
	<link rel="stylesheet"
		href="<c:url value='https://demo-basic.adminkit.io/icons-feather.html' />" />
	<link rel="stylesheet"
		href="<c:url value='/template/admin/tplnew/img/icons/icon-48x48.png' />" />
	<link rel="stylesheet"
		  href="<c:url value='/template/admin/tplnew/css/style.css' />" />
	<link rel="stylesheet"
		href="<c:url value='https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap' />" />

	<link rel="stylesheet" href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css' />" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

	<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
<%--	<script src="<c:url value='/template/ckeditor5/ckeditor5.js' />"></script>--%>
	<link rel="stylesheet" href="<c:url value="https://cdn.ckeditor.com/ckeditor5/42.0.1/ckeditor5.css"/>" />

<%--	<script src="<c:url value='/template/ckeditor/ckeditor.js'/>"></script>--%>
<%--	<script src="https://cdn.ckeditor.com/ckeditor5/38.2.1/classic/ckeditor.js"></script>--%>
<%--	<script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>--%>
	<style>
	  .font {
		font-size: 12px;
	  }
	</style>
</head>
<body >

	<!-- header -->
	 <%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div class="main-container" id="main-container">
		
		<div class="lg-12 d-flex">
			<!-- side -->
			<%@ include file="/common/admin/menu.jsp"%>
			<!-- side -->

			<dec:body />
		</div>
	</div>
	<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
	<!-- footer -->


	<script src="<c:url value='/template/admin/tplnew/js/app.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	<script src="js/app.js"></script>
</body>
</html>