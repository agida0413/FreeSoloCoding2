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
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<section class="breadcrumb-section set-bg" data-setbg="../img/banner_2.jpeg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>HospitalSearch</h2>
                        <div class="breadcrumb__text">
                            <a href="../main/main.do">Home</a>
                            <span></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<!-- Blog Details Section Begin -->
			<section class="blog-details spad">
				<div class="container">
					<div class="row">
						<div class="blog__sidebar__search">
							<div class="col-lg-4 col-md-5 order-md-1 order-1">
								<form method="post" action="find.do">
									<select id="state" name="st" size="2">
									<option value="전체">전체</option>
										<c:forEach var="vo" items="${list2}">
											<option value="${vo.state }">${vo.state}</option>
										</c:forEach>

									</select>

									<div class="blog__sidebar__search"
										style="width: 300px; margin-right: 500px;">

										<input type="text" placeholder="Search..." name="fd"
											value="${fd eq null?"":fd}"
											style="height: 40px; width: 230px;">
										<button type="submit">
											<span class="icon_search"></span>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>

			<div class="col-lg-8 col-md-7 order-md-1 order-2">
				<div class="blog__details__text">
					<h4 style="text-align: center;">병원 목록</h4>
					<br>
					<table class="table">
						<tr class="success">
							<th width=10% class="text-center">번호</th>
							<th width=30% class="text-center">병원명</th>
							<th width=40% class="text-center">주소</th>
							<th width=20% class="text-center">전화번호</th>
						</tr>
						<c:forEach var="vo" items="${list }">
							<tr>
								<td width=10% class="text-center">${vo.no}</td>
								<td width=30% class="text-center"><a
									href="../hspt/detail.do?no=${vo.no }">${vo.hospital_name }</a></td>
								<td width=40% class="text-center">${vo.hospital_address }</td>
								<td width=20% class="text-center">${vo.hospital_phone }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="order-3" style="margin: 0 auto;">
				<div class="product__pagination">
					<c:if test="${startPage>1 }">
						<a href="find.do?page=${startPage-1}"><i
							class="fa fa-long-arrow-left"></i></a>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:choose>
							<c:when test="${i eq curpage}">
								<a href="find.do?page=${i}" class="selected">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="find.do?page=${i}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${endPage<totalpage }">
						<a href="find.do?page=${endPage+1}"><i
							class="fa fa-long-arrow-right"></i></a>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<!-- Blog Details Section End -->

</body>

</html>