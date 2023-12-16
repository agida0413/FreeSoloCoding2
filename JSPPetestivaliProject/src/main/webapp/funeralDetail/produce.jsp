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
   <!-- Contact Form Begin -->
    <div class="contact-form spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="contact__form__title">
              <h2>장례 절차</h2>
            </div>
          </div>
        </div>
        <p class="funeral_res"><a href="#">장례 예약하기</a></p>
      </div>
    </div>
  <c:forEach var="i" begin="1" end="8">
    <div class="funeral_produce_all container">
      <div class="funeral_produce funeral_1 row">
        <img src="${vo.infoimage }" alt="" />이미지
        <div>
          <span>숫자${vo.mno }</span>
          <h3>제목${vo.infoh3 }</h3>
          <p>내용${vo.infop }</p>
          <div>
          <jsp:include page="ok.jsp"></jsp:include>
          </div>
        </div>
      </div>
    </div>
   </c:forEach>
    <!-- Contact Form End -->
   
</body>
</html>