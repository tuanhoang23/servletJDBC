<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    
    <title><dec:title default="Trang chủ"></dec:title></title>
    <link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
</head>
<body>
    
    <%@ include file="/common/web/header.jsp" %> 

    <div class="container">
        <dec:body/>
    </div>

    <%@ include file="/common/web/footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<c:url value='/template/web/js/scripts.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.js' />"></script>
</body>
</html>