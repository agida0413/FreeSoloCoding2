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
    
	<section class="blog-details spad">
		<div class="container">
			<div class="row">
				<div class="blog__sidebar__search">
					<div class="col-lg-4 col-md-5 order-md-1 order-1">
						<form method="post" action="hsptsearch.do">
							<select id="state" name="st" size="2">
								<option value="전체">전체</option>
								<c:forEach var="vo" items="${statelist}">
									<option value="${vo.state }" ${vo.state eq "${vo.state}"?"selected":""}>
									${vo.state}</option>
								</c:forEach>
							</select>

							<div class="blog__sidebar__search"
								style="width: 300px; margin-right: 500px;">

								<input type="text" placeholder="Search..." name="fd"
									value="${fd eq null?"":fd }"
											style="height: 40px; width: 230px;">
								<button type="submit">
									<span class="icon_search"></span>
								</button>
							</div>
						</form>
					</div>
				</div>
	
	</div>
	</div>
	<jsp:include page="${hspt_jsp }"></jsp:include>
	</section>
</body>
</html>