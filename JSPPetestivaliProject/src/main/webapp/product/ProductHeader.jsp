<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div>
        <ul class="nav nav-pills" style="margin-left: 765px; margin-bottom: 50px;">
  	  <li class="active"><a href="ProductMain.do?ct=${ct }&rt=p_intprice">가격순</a></li>
 	  <li><a href="ProductMain.do?ct=${ct }&rt=p_hit"  style="margin-left: 50px;">조회수</a></li>
  	  <li><a href="ProductMain.do?ct=${ct }&rt=p_review_num" style="margin-left: 50px;">후기개수</a></li>
     <li><a href="ProductMain.do?ct=${ct }&rt=p_stack" style="margin-left: 50px;">품절임박</a></li>
	    </ul> 
	    
        </div>
</body>
</html>