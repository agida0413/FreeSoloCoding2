<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">


<style type="text/css">
 .my_container {
  display: flex;
  width: 1140px;
  height: 1500px;
  margin: 0 auto;
  background-color: orange;
}

.my_info {
  margin: 10px 0px 0px 50px;
}

.my_menu {
  margin-top: 10px; /* 간격 조절을 위해 추가 */
}

</style>
</head>
<body style='margin: 0px'>
	<section class="breadcrumb-section set-bg"
		data-setbg="../img/banner_2.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>MyPage</h2>
						<div class="breadcrumb__text">
							<a href="../main/main.do">Home</a> <span></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<div class="my_container">
		<div class="row">
			<div class="my_info">
				<div class="profile_picture">
					<img src="../img/mainlogo.png" alt="Profile Picture">
				</div>
				<div class="user_details">
					<h3>스트릿두식</h3>
					<p>nyumnyum@petstival.com</p>
					<!-- 기타 사용자 정보 추가 -->
				</div>
			</div>
			<div class="my_menu">
				<div class="blog__sidebar__item">
					<div class="user_menu">
						<div class="breadcrumb__text">
							<ul>
								<li><a href="../mypage/myres.do">예약내역</a></li>
								<li><a href="#">구매내역</a></li>
								<li><a href="#">위시리스트</a></li>
								<li><a href="#">개인정보관리</a></li>
								<li><a href="#">마이펫관리</a></li>
							</ul>
						</div>
					</div>
				</div>
				</div>
				<jsp:include page="${mypage_jsp}"></jsp:include>
		</div>
	</div>
</body>
</html>