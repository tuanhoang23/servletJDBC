
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<%-- <div id="sidebar"
	class="sidebar responsive ace-save-state">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
	<div class="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="ace-icon fa fa-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="ace-icon fa fa-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="ace-icon fa fa-users"></i>
			</button>

			<button class="btn btn-danger">
				<i class="ace-icon fa fa-cogs"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text"></span>
				Quản lý bài viết <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href='<c:url value="/admin-news-list"/>'>
						<i class="menu-icon fa fa-caret-right"></i> DS bài viết
				</a> <b class="arrow"></b></li>
			</ul>
		</li>
	</ul>
	<div class="sidebar-toggle sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div> --%>
<nav id="sidebar" class=" font sidebar js-sidebar">
<div class="sidebar-content js-simplebar">
	<a class="sidebar-brand" href="index.html"> <span
		class="align-middle">AdminKit</span>
	</a>

	<ul class="sidebar-nav">


		<li class="sidebar-item">
			<c:url var="menuUrl" value="/admin-news">
				<c:param name="page" value="1"/>
				<c:param name="maxPageItem" value="2"/>
				<c:param name="sortName" value="title"/>
				<c:param name="sortBy" value="desc"/>
				<c:param name="type" value="list"/>
			</c:url>
			<a class="sidebar-link" href="${menuUrl}">
<%--				<i class="align-middle" data-feather="sliders"></i>--%>
				<i class="fa-solid fa-list"></i>
				<span class="align-middle">Danh sách bài viết</span>
			</a>
		</li>

	</ul>
</div>
</nav>
