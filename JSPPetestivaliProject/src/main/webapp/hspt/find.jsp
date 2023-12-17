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

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
<div id="preloder">
        <div class="loader"></div>
    </div>


    <!-- Blog Details Section Begin -->
	<section class="blog-details spad">
		<div class="container">
			<div class="row">
			<div class="blog__sidebar__search">
				<div class="col-lg-4 col-md-5 order-md-1 order-1">
						<form method="post" action="find.do">
							<select id="state" name="ss" size="2">
								<option value="address"
									${ss eq "${hospital_address}"?"selected":""}>
									<c:forEach var="vo" items="${list2}">
										<option value="${vo.state }">${vo.state}</option>
									</c:forEach>
								</option>
							</select> 
							
							 <div class="blog__sidebar__search" style=" width: 300px; margin-right: 500px;">
								 <input type="text" placeholder="Search..." name="name" value="name" ${ss eq "${hospital_address}"?"selected":""} style="height:40px; width:230px;">
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

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>



</body>

</html>