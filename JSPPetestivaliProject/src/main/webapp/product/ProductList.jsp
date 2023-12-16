
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
                        <a href="../product/ProductList.do?page=${start-1 }&ct=${ct}&rt=${rt}">&lt;</a>
                        </c:if>
                        <c:forEach var="i" begin="${start }" end="${end }">
                        
                        <a href="../product/ProductList.do?page=${i }&ct=${ct}&rt=${rt}"">${i }</a>
                       </c:forEach>
                        
                        <c:if test="${end < totalpage}">
                       <a href="../product/ProductList.do?page=${end + 1}&ct=${ct}&rt=${rt}""><i class="fa fa-long-arrow-right"></i></a>
                        </c:if>
                        </center>
                    </div>
                </div>
    
    <!-- Product Section End -->

   

    
    


</body>

</html>