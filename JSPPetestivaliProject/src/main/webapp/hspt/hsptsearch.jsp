<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ogani | Template</title>
<style type="text/css">
.product__pagination a.selected {
	background-color: #007bff;
	color: #fff;
	border: 1px solid #007bff;
}

.blog__sidebar__search button[type="text"] {
	margin-right: 140px;
}
</style>

</head>

<body>

	<!-- Blog Details Section Begin -->
			<section class="blog-details spad">
				<div class="container">
				<div class="row">

			<!-- 검색바 -->
			<div class="blog__sidebar__item">
		<h2 style="text-align: center;">병원찾기 목록</h2>
		<table class="table">
			<tr class="success">
				<th width=10% class="text-center">번호</th>
				<th width=30% class="text-center">병원명</th>
				<th width=40% class="text-center">주소</th>
				<th width=20% class="text-center">전화번호</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td width=10% class="text-center">${vo.no }</td>
					<td width=30% class="text-center"><a
						href="../hspt/detail.do?no=${vo.no }">${vo.hospital_name }</a></td>
					<td width=40% class="text-center">${vo.hospital_address }</td>
					<td width=20% class="text-center">${vo.hospital_phone }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
			
			<div class="order-3" style="margin: 0 auto;">
				<div class="product__pagination">
					<c:if test="${startPage>1 }">
						<a href="hsptsearch.do?page=${startPage-1}&st=${st }&fd=${fd }"><i
							class="fa fa-long-arrow-left"></i></a>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:choose>
							<c:when test="${i eq curpage}">
								<a href="hsptsearch.do?page=${i}&st=${st }&fd=${fd }" class="selected">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="hsptsearch.do?page=${i}&st=${st }&fd=${fd }">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${endPage<totalpage }">
						<a href="hsptsearch.do?page=${endPage+1}&st=${st }&fd=${fd }"><i
							class="fa fa-long-arrow-right"></i></a>
					</c:if>
				</div>
			</div>
		</div>
		</div>
	</section>
	<!-- Blog Details Section End -->

</body>

</html>