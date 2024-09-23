<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>;
<c:url var="APIurl" value="/api-admin-news" />
<c:url var="newUrl" value="/admin-news" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<main class="content">
	<form action="<c:url value="/admin-news"/>" id="formSubmit" method="get">
		<div class="container-fluid p-0">
			<div>
				<span class="text-center h1 responsive-font">QUẢN LÝ BÀI VIẾT</span>
			</div>
			<div class="mt-5">
				<div class="d-flex justify-content-end">
					<a class="btn btn-success btn-lg " title="thêm bài viết" href="<c:url value="/admin-news?type=edit"/>" >
						<i class="fa-solid fa-folder-plus m-1"></i>
						<span class="">Thêm</span>
					</a>
					<a class="btn btn-danger btn-lg mx-2" title="thêm bài viết" href="" id="btnRemove" >
						<i class="fa-solid fa-trash m-1"></i>
						<span class="">Xóa</span>
					</a>
				</div>
				<table class="table mt-100">
					<thead class="text-center">
						<tr>
							<th scope="col">Tên bài viết</th>
							<th scope="col">Mô tả ngắn</th>
							<th scope="col">#</th>
							<th scope="col"><input type="checkbox" id="checkAll"><span class="p-1">All</span></th>

						</tr>
					</thead>
					<tbody class="table-group-divider text-center">
						<c:forEach var="item" items="${model.result}">
							<tr>

								<td>${item.title}</td>
								<td>${item.shortDescription }</td>
								<td width="5%">
									<c:url var="editUrl" value="/admin-news">
										<c:param name="type" value="edit"/>
										<c:param name="id"  value="${item.id}"/>
									</c:url>
									<a class="btn btn-info" title="sửa" href='${editUrl}'><i class="fa-solid fa-pen-to-square m-1"></i>sửa</a>
								</td>
								<td width="5%"><input type="checkbox" id="c_${item.id}" value="${item.id}"></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="d-flex justify-content-end  ">
					<ul class="pagination" id="pagination"></ul>
					<input type="hidden" id="page" name="page">
					<input type="hidden" id="maxPageItem" name="maxPageItem">
					<input type="hidden" id="sortName" name="sortName">
					<input type="hidden" id="sortBy" name="sortBy">
					<input type="hidden" id="type" name="type">
				</div>
			</div>
		</div>
	</form>
	</main>



	<script type="text/javascript">
		var totalPages = ${model.totalPages};
		var currentPage = ${model.page};
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if(currentPage !== page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val("title");
						$('#sortBy').val("desc");
						$('#type').val("list");
						$('#formSubmit').submit();
					}
					
				}
			});
		});

		$('#btnRemove').click(function (){
			var data = {};
			var dataArray = $("tbody input[type=checkbox]:checked").map(function (){
				return $(this).val();
			}).get();
			data['ids'] = dataArray;
			remove(data);
		});

		function remove(data){
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				contentType:'application/json',
				data: JSON.stringify(data),
				success: function (succes) {
					window.location.href = '${newUrl}?type=list&maxPageItem=2&page=1';
				},
				error: function (error) {
					console.log(error);
				}
			});
		}
	</script>
</body>

</html>