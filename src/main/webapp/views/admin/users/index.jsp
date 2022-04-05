<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">
		${ sessionScope.message }
		<c:remove var="message" scope="session" />
	</div>
</c:if>
<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">
		${ sessionScope.error }
		<c:remove var="error" scope="session" />
	</div>
</c:if>

<h2>
	<fmt:formatDate value="${ now }"
		pattern="dd/MM/yyyy" />
</h2>

<c:if test="${ empty ds }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>

<c:if test="${ !empty ds }">
	<table class="table">
		<thead class="table-dark">
			<th>Họ tên</th>
			<th>Giới tính</th>
			<th>SĐT</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th colspan="2">Thao tác</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="user">
				<tr>
					<td>${ user.hoTen }</td>
					<td>
					<c:choose>
						<c:when test="${ user.gioiTinh == 1 }">Nam</c:when>
						<c:when test="${ user.gioiTinh == 0 }">Nữ</c:when>
						<c:otherwise> - </c:otherwise>
					</c:choose>
					</td>
					<td>${ user.sdt }</td>
					<td>${ user.email }</td>
					<td>${ user.diaChi }</td>
					<td>
						<a
							href="/SP22B2_SOF3011_IT16309/users/edit?id=${ user.id }"
							class="btn btn-primary">
							Cập nhật
						</a>
					</td><td>
						<a
							href="/SP22B2_SOF3011_IT16309/users/delete?id=${ user.id }"
							class="btn btn-danger">
							Xóa
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
