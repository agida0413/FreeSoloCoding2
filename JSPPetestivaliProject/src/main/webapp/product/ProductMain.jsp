<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="product spad">
        <div class="container">
		<jsp:include page="ProductHeader.jsp"></jsp:include>
		<div class="row">
		<jsp:include page="ProductCategory.jsp"></jsp:include>
		<jsp:include page="${product_jsp }"></jsp:include>
		 </div>
		 
		

  </div>
    </section>
</body>
</html>