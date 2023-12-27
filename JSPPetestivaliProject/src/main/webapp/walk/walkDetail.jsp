<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style type="text/css">


	
	
	
</style>	

<meta charset="UTF-8">
<title>Insert title here</title>
 
</head>
<body>
    

   

    <!-- Blog Details Hero Begin -->
    <section class="blog-details-hero set-bg" data-setbg="../img/blog/details/details-hero.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="blog__details__hero__text">
                        <h2>The Moment You Need To Remove Garlic From The Menu</h2>
                        <ul>
                            <li>By Michael Scofield</li>
                            <li>January 14, 2019</li>
                            <li>8 Comments</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Hero End -->

    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
        
            <div class="row">
            
                <div class="col-lg-4 col-md-5 order-md-1 order-2">
                    <div class="blog__sidebar kyj_walk"><!--산책로 디테일 왼쪽 사이드메뉴 -->
                        <span class="top_link"><a href="../walk/walkList.do?page=${param.page }&loc=${param.loc}"><img src="../img/left.png.svg" alt="">목록</a></span>
                        <a href="https://map.kakao.com/link/to/${vo.wname },${vo.cLa },${vo.cLo}" target="_blank">길찾기</a>
                     	<a href="https://map.kakao.com/link/roadview/${vo.cLa },${vo.cLo}" target="_blank">로드뷰 보기</a>
                        
                    </div>
                    
                </div>
                <div class="col-lg-8 col-md-7 order-md-1 order-1">
                    <div class="blog__details__text">
                         
     
<div id="map" style="width:100%;height:300px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	c2368186c0091fdb14d91b7b4aa613ff&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${vo.address}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.wname}</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
     
               
                      
                    </div>
                    <h1>${vo.wname }</h1>
                    <div>
						<ul class="walk_course"> <!-- 코스이름별 에이젝스 이용 코스정보출력예정-->
							<li><a href="#">코스이름</a></li>
							<li><a href="#">코스이름</a></li>
							<li><a href="#">코스이름</a></li>
							<li><a href="#">코스이름</a></li>
							
						</ul>
						
					</div>
                    
                   
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->

    <!-- Related Blog Section Begin -->
    <section class="related-blog spad">
        <div class="container">
           <div class="row">
           		<div class="comment-section" style="width:100%">
    <h3 style="margin-bottom:20px;">댓글(${replyAmount})</h3>
    <c:if test="${sessionScope.id !=null }">
    <form id="commentForm" action="replyInsert.do" method="post">
        <div class="input-group">
           
            <textarea rows="4" cols="130" name="rcontent" id="rcontent" placeholder="댓글을 입력해주세요" required></textarea>
           	 <div class="row" style="margin-top:5px; margin-left:1010px; margin-bottom:10px;">
        	 <input type="password" size="10" name="password" id="password" placeholder="비밀번호" required>
        	   <input type="submit" value="등록">

        </div>    
            <input type="hidden" name="wno" value="${vo.wno}">
            <input type="hidden" name="page" value="${curpage}">
            <input type="hidden" name="loc" value="${loc}">
          
        </div>
       <hr>
    </form>
    </c:if>

    <div class="comment-list">
        <c:forEach var="rvo" items="${rlist}" varStatus="loop" >
           <div class="comment" data-index="${loop.index}">
   			
   			 <div class="comment-header">
       		 <span>
       		 <c:if test="${rvo.group_tab>0 }">
       		
       		 
       		 <c:forEach var="i" begin="1" end="${rvo.group_tab }">
   			 &nbsp;&nbsp;&nbsp;
   			 </c:forEach>
   			 
       		 
       	
   			 </c:if>
       		
       		 ${rvo.userid }
       		 
       		 </span> 
   			     <div class="comment-actions" style="float:right; height:20px;">
   			     
   			     <c:if test="${sessionScope.id eq rvo.userid }">
            <button class="modifyBtn btn btn-sm btn-info">수정</button>
            <button class="deleteBtn btn btn-sm btn-info">삭제</button>
            </c:if>
           <c:if test="${sessionScope.id != rvo.userid && sessionScope.id != null}">
            <button class="replyBtn btn btn-sm btn-info">답글</button>
           
            </c:if>
            
        </div>
        
    </div>
   				
   			
   				
   			<div class="mainContent">
   			<c:if test="${rvo.group_tab>0 }">
       		 <c:forEach var="i" begin="1" end="${rvo.group_tab }">
   			 &nbsp;&nbsp;&nbsp;
   			 </c:forEach>
   			 </c:if>
   			
  			  <span class="mc">${rvo.rcontent}</span>
    			  <span style="float:right;" class="dbday">${rvo.dbday }</span>
   			</div>
   			
   			
   			
                
               
         <div style="display: none;" class="addreply">
           
           <form id="commentForm" action="addReply.do" method="post">
         <c:if test="${rvo.group_tab>0 }">
       		 <c:forEach var="i" begin="1" end="${rvo.group_tab }">
   			 &nbsp;&nbsp;&nbsp;
   			 </c:forEach>
   			 </c:if>	
        	<textarea rows="4" cols="70" name="addcontent" id="addcontent" placeholder="답변을 입력해주세요" required></textarea>
           	 <div class="row" style="margin-top:5px; margin-left:555px; margin-bottom:10px;">
           	 <c:if test="${rvo.group_tab>0 }">
       		 <c:forEach var="i" begin="1" end="${rvo.group_tab }">
   			 &nbsp;&nbsp;&nbsp;
   			 </c:forEach>
   			 </c:if>	
        		 <input type="password" size="10" name="addpassword" id="addrpassword" placeholder="비밀번호" required>
        	     <input type="submit" value="등록">
       	    </div>    
          	  <input type="hidden" name="wno" value="${vo.wno}">
          	  <input type="hidden" name="page" value="${curpage}">
          	  <input type="hidden" name="loc" value="${loc}">
          	  <input type="hidden" name="rno" value="${rvo.rno}">
    	</form>
       </div>
      
              
              
                	 	<form action="replyDelete.do" method="post">
                	 	<div class="dpassword" style="display:none;">
                	 	<c:if test="${rvo.group_tab>0 }">
       						 <c:forEach var="i" begin="1" end="${rvo.group_tab }">
   								 &nbsp;&nbsp;&nbsp;
   							 </c:forEach>
   				 	   </c:if>
                		<input type="password" name="dpassword" placeholder="비밀번호"  required>
                		 <input type="hidden" name="wno" value="${vo.wno}">
          				  <input type="hidden" name="page" value="${curpage}">
          				  <input type="hidden" name="loc" value="${loc}">
          	 			 <input type="hidden" name="rno" value="${rvo.rno}">
                		<button>삭제</button>
                		</div>
                	</form>
                	
                	
                
                
         <div style="display: none;" class="modifyreply">
         	
         	
           <form id="commentForm" action="replyUpdate.do" method="post">
           		<c:if test="${rvo.group_tab>0 }">
       		 <c:forEach var="i" begin="1" end="${rvo.group_tab }">
   			 &nbsp;&nbsp;&nbsp;
   			 </c:forEach>
   			 </c:if>
           
            	<textarea rows="4" cols="70" name="upcontent" id="upcontent"  required>${rvo.rcontent }</textarea>
           	 <div class="row" style="margin-top:5px; margin-left:555px; margin-bottom:10px;">
           	 			<c:if test="${rvo.group_tab>0 }">
       		 <c:forEach var="i" begin="1" end="${rvo.group_tab }">
   			 &nbsp;&nbsp;&nbsp;
   			 </c:forEach>
   			 </c:if>
           	 
        		 <input type="password" size="10" name="uppassword" id="uppassword" placeholder="비밀번호" required>
        	     <input type="submit" value="수정">

       	    </div>    
          	  <input type="hidden" name="wno" value="${vo.wno}">
          	  <input type="hidden" name="page" value="${curpage}">
          	  <input type="hidden" name="loc" value="${loc}">
          	   <input type="hidden" name="rno" value="${rvo.rno}">
    	  </form>
       </div>
          <hr>
            </div>
        </c:forEach>
    </div>
</div>
           </div>
        </div>
    </section>
    <!-- Related Blog Section End -->

   

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