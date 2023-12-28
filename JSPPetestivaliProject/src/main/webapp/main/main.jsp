<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<style type="text/css">


.latest-product__slider.owl-carousel .owl-nav {
    position: absolute;
    left: -120px !important;
    top: 400px !important;
 }
.hero__item{
  position: relative;
}
.latest-product__item__text{
  position: absolute;
  top: 150px;
  right: 100px;
}
.latest-product__item__text span{
  margin-top: 50px;
}
.hotelbanner{
  color: #fff !important;
  font-weight: 700px;
  left: 0px !important;
  right: 0px !important;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>
    
    <!-- xeicon -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
        <link rel="stylesheet" href="../css/product.css" type="text/css">
        <link rel="stylesheet" href="../css/product_detail.css?no=112" type="text/css">
        <link rel="stylesheet" href="../css/productCategory.css">
         <link rel="stylesheet" href="../css/walk.css?no=123" type="text/css">
        	
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- home -->
	<jsp:include page="${main_jsp}"></jsp:include>
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>

    <!-- Js Plugins -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/main.js"></script>
    <script src="../js/product_detail.js"></script>
   <script src="../js/productCategory.js"></script>
        <script src="../js/product_calculate.js"></script>
         <script src="../js/walk_reply_ajax.js"></script>
</body>
</html>