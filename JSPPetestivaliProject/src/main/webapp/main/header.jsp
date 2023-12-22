<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                           <ul>
                              <li class="aaa"><i class="fa fa-envelope"></i> PETSTIVAL@gmail.com</li>
                              <li>Give the gift of love to your little family</li>
                           </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                        
                        <c:if test="${not empty sessionScope.id}">
                            <div class="header__top__right__auth">
                            <a href="../mypage/mypagemain.do"><i class="fa fa-user"></i> Mypage</a>
                            </div>
                            &nbsp;&nbsp;
                            <div class="header__top__right__auth">
                                <a href="../user/userLogout.do"><i class="fa fa-user"></i> Logout</a>
                            </div>
                        </c:if>		
                        
                           
                            <c:if test="${sessionScope.id eq null }">
                            <div class="header__top__right__auth">
                            <a href="../user/join.jsp"><i class="fa fa-user"></i> Join</a>
                            </div>
                            &nbsp;&nbsp;
                            <div class="header__top__right__auth">
                                <a href="../user/login.jsp"><i class="fa fa-user"></i> Login</a>
                            </div>
                            </c:if>
                            
                            
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                       <a href="../main/main.do">
                       <h2>PETSTIVAL<img src="../img/mainlogo.png" width="35px" height="35px">
                       </h2>
                       </a>
                    </div>
                 </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="../product/ProductList.do">SHOP</a>
                               <ul class="header__menu__dropdown">
                                   <li><a href="../product/ProductList.do">전체상품</a></li>
                                    <li><a href="../product/ProductList.do?ct=사료">사료</a></li>
                                    <li><a href="../product/ProductList.do?ct=간식">간식</a></li>
                                    <li><a href="../product/ProductList.do?ct=배변/위생">배변/위생</a></li>
                                    <li><a href="../product/ProductList.do?ct=목욕/미용">목욕/미용</a></li>
                                    <li><a href="../product/ProductList.do?ct=장난감">장난감</a></li>
                                    <li><a href="../product/ProductList.do?ct=건강관리">건강관리</a></li>
                                    <li><a href="../product/ProductList.do?ct=식기">식기</a></li>
                                    <li><a href="../product/ProductList.do?ct=산책/이동장">산책/이동장</a></li>
                                    <li><a href="../product/ProductList.do?ct=하우스/울타리">하우스/울타리</a></li>
                                </ul>
                            </li>
                            <li><a href="#">HEALTH</a>
                               <ul class="header__menu__dropdown">
                                    <li><a href="../hspt/hsptmain.do">병원 검색하기</a></li>
                                    <li><a href="../hspt/newsmain.do">펫케어 콘텐츠</a></li>
                                </ul>
                            </li>
                            <li><a href="#">HOTEL</a></li>
                            <li><a href="../funeralDetail/produce.do">FUNERAL</a>
                               <ul class="header__menu__dropdown">
                                    <li><a href="#">장례 절차 안내</a></li>
                                    <li><a href="#">장례식장 검색하기</a></li>
                                    <li><a href="#">장례 예약하기</a></li>
                                </ul>
                            </li>
                            <li><a href="../funeralDetail/produce.do">COMMUNITY</a>
                               <ul class="header__menu__dropdown">
                                    <li><a href="#">자유게시판</a></li>
                                    <li><a href="#">반려동물 자랑게시판</a></li>
                                    <li><a href="#">문의게시판</a></li>
                                    <li><a href="#">공지사항</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>0&#8361;</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>ETC</span>
                        </div>
                        <ul>
                            <li style="font-weight: 700;"><a href="#"><i class="xi-home"></i>&nbsp;유기견 보호 센터</a></li>
                            <li style="text-indent: 20px"><a href="#">실종 동물 목록</a></li>
                            <li style="text-indent: 20px"><a href="#">보호중인 유기 동물</a></li>
                            <li style="text-indent: 20px"><a href="#">보호 동물 입양</a></li>
                            <li style="font-weight: 700;"><a href="#"><i class="xi-walk"></i>&nbsp;반려동물 산책로</a></li>
                            <li style="text-indent: 20px"><a href="../walk/walkList.do">가까운 산책로 찾기</a></li>
                            <li style="font-weight: 700;"><a href="#"><i class="xi-heart"></i>&nbsp;마이펫 관리</a></li>
                            <li style="text-indent: 20px"><a href="../mypage/petreg.do">마이펫 등록</a></li>
                            <li style="text-indent: 20px"><a href="#">마이펫 관리</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <c:if test="${not empty sessionScope.id}">
                            <div class="hero__search__phone__text">
                                <h5>${sessionScope.name }님 환영합니다.</h5>
                           </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
    
    
    <c:if test="${not empty LogoutMsg}">
    <script>
        var loutmsg = "${LogoutMsg}";
        if (loutmsg !== null && loutmsg.trim().length > 0) {
            alert(loutmsg);
        }
    </script>
</c:if>
</body>
</html>