<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.prod_page a:hover
  		{
  		  background-color: #333;
    color: #fff;
    border-color: #333;
  		}
  		
  	

</style>

</head>
<body>

  <div class="row ky">
    									
    									          
	                <div class="col-lg-8 col-md-7">
                    <div class="row">
                    	<c:forEach var="vo" items="${list }">
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="blog__item">
                                
                                <div class="blog__item__text">
                                   
                                    <h5><a href="#">${vo.wname }</a></h5>
                                    <p>${vo.signgu_name }</p>
                                    <p>${vo.address }</p>
                                    <a href="../walk/walkDetail.do?wno=${vo.wno }&page=${curpage}&loc=${loc}" class="blog__btn">더보기 ...<span class="arrow_right"></span></a>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                   
                        
                        <div class="col-lg-12">
                            
                            <div class="product__pagination blog__pagination prod_page">
                               <center>
                    <c:if test="${start > 1}">
                        <a href="../walk/walkList.do?page=${start-1 }&loc=${loc}"><i class="fa fa-long-arrow-left"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${start }" end="${end }">
                        	
                          <c:choose>
									<c:when test="${i eq curpage}">
									 <a href="../walk/walkList.do?page=${i }&loc=${loc}" class="kyj_selected">${i }</a>
										
									</c:when>
									<c:otherwise>
									  <a href="../walk/walkList.do?page=${i }&loc=${loc}">${i }</a>
									</c:otherwise>
								</c:choose>
                       </c:forEach>
                        
                        <c:if test="${end < totalpage}">
                       <a href="../walk/walkList.do?page=${end+1 }&loc=${loc}"><i class="fa fa-long-arrow-right"></i></a>
                        </c:if>
                        </center>
                            </div>
                        </div>
                    </div>
                </div>
            </div>





</body>
</html>