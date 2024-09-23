<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container ">
		<a class="navbar-brand" href="#!">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>


			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#">Trang chủ</a></li>
					<c:if test="${not empty USERMODEL}" >
						<li class="nav-item"><a class="nav-link" href="#!">Wellcome,${USERMODEL.fullName}</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value='/logout?action=logout'/>">Thoát</a></li>
						<c:if test="${not empty message}">
							<div class="alert alert-${alert} m-2" role="alert">
									${message}
							</div>
						</c:if>
					</c:if>
					<c:if test="${empty USERMODEL}" >
						<li class="nav-item"><a class="nav-link" href="<c:url value='/login?action=login'/>">Đăng nhập</a></li>

					</c:if>
				</ul>
			</div>


	</div>
</nav> 

