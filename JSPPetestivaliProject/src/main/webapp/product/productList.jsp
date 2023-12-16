
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zxx">


<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

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
    <style type="text/css">
    .nav-pills{
    color:black;
    
    }
    </style>
</head>

<body>
  
	
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
        
        <div>
        <ul class="nav nav-pills" style="margin-left: 765px; margin-bottom: 50px;">
  	  <li class="active"><a href="productList.do?ct=${ct }&rt=p_intprice">가격순</a></li>
 	  <li><a href="productList.do?ct=${ct }&rt=p_hit"  style="margin-left: 50px;">조회수</a></li>
  	  <li><a href="productList.do?ct=${ct }&rt=p_review_num" style="margin-left: 50px;">후기개수</a></li>
     <li><a href="productList.do?ct=${ct }&rt=p_stack" style="margin-left: 50px;">품절임박</a></li>
	    </ul> 
	    
        </div>
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>카테고리</h4>
                            <ul>
                                <li><a href="productList.do?ct=전체">전체</a></li>
                                <li><a href="productList.do?ct=사료">사료</a></li>
                                <li><a href="productList.do?ct=간식">간식</a></li>
                                <li><a href="productList.do?ct=배변/위생">배변/위생</a></li>
                                <li><a href="productList.do?ct=목욕/미용">목욕/미용</a></li>
                                <li><a href="productList.do?ct=장난감">장난감</a></li>
                                <li><a href="productList.do?ct=건강관리">건강관리</a></li>
                                <li><a href="productList.do?ct=식기">식기</a></li>
                                <li><a href="productList.do?ct=산책/이동장">산책/이동장</a></li>
                                <li><a href="productList.do?ct=하우스/울타리">하우스/울타리</a></li>
                                
                            </ul>
                        </div>
                        
                        
                      
                     
                    </div>
                </div>
                
               
              <div class="col-lg-9 col-md-7">
                    <div class="row">
              				<c:forEach var="vo" items="${list }">
             						 <div class="col-lg-4 col-md-6 col-sm-6">
             						  <a href="DetailBefore.do?pno=${vo.pno }">
             						  <img src="${vo.p_image }">
                       					 <div class="product__item">
                    		  	 	  <div class="product__item__text">
                               			  <h5>${vo.p_name }</h5>
                                    <h6>${vo.p_lower_price }</h6>
                                </div>
                                </div>
   									   </a>
                         </div>
                        
                        </c:forEach>
                            </div>
                        
                                  
                        
                     
                      	 	
                    		 
                    		  
                    		  
                       
                    	
               
                                  
                                
                              
                        
                        
                              
                           
                  
                        
                        
                                
                                
                            
                               
                    <div class="product__pagination">
                    <center>
                    <c:if test="${start > 1}">
                        <a href="../product/productList.do?page=${start-1 }&ct=${ct}&rt=${rt}">&lt;</a>
                        </c:if>
                        <c:forEach var="i" begin="${start }" end="${end }">
                        
                        <a href="../product/productList.do?page=${i }&ct=${ct}&rt=${rt}"">${i }</a>
                       </c:forEach>
                        
                        <c:if test="${end < totalpage}">
                       <a href="../product/productList.do?page=${end + 1}&ct=${ct}&rt=${rt}""><i class="fa fa-long-arrow-right"></i></a>
                        </c:if>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

   

    
    


</body>

</html>