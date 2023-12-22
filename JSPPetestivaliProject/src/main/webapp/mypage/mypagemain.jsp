<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.my_container{

	width: 1140px;
	height: 600px;
	margin: 0px auto;
	
	
}
.breadcrumb-section
{
	margin-top: 30px;
}
.blog__sidebar__item{
 margin-left: 80px;
 margin-top: 50px;
}
</style>
</head>
<body>
<section class="breadcrumb-section set-bg" data-setbg="../img/banner_2.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>MyPage</h2>
                        <div class="breadcrumb__text">
                            <a href="../main/main.do">Home</a>
                            <span></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<div class="my_container">
		<div class="row">
			
				<div class="blog__sidebar__item">
					
					<ul>
						<li><a href="../mypage/res.do">예약내역</a></li>
						<li><a href="#">구매내역</a></li>
						<li><a href="#">위시리스트</a></li>
						<li><a href="#">개인정보관리</a></li>
						<li><a href="#">마이펫관리</a></li>
					</ul>
				</div>
			
		
			<jsp:include page="${mypage_jsp}"></jsp:include>
	</div>
	</div>
</body>
</html>