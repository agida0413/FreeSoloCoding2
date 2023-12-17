<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.selected {
  background-color: #c0c0c0; /* 약간 흐릿한 회색 배경색 */
  border-radius: 5px; /* 모서리를 둥글게 */
  padding: 5px 10px; /* 여백 설정 */
  color: #fff; /* 텍스트 색상 */
  font-weight: bold; /* 텍스트 굵게 */
  text-decoration: none; /* 링크 텍스트의 밑줄 제거 */
  transition: background-color 0.3s ease; /* 부드러운 전환 효과 */
}

.selected:hover {
  background-color: #a9a9a9; /* 호버 시 약간 진한 회색 */
  color: #fff; /* 호버 시 텍스트 색상 */
}
.customimage {
    border: 2px solid rgba(52, 152, 219, 0.1); /* 매우 투명한 파란색 실선 테두리 */
  border-radius: 20px; /* 둥근 테두리 설정 */
  box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.1); /* 더 투명하고 부드러운 그림자 효과 */
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

<section class="breadcrumb-section set-bg" data-setbg="../img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>상품</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">상품을 느껴보세요</a>
                            <span>용품</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

<section class="product spad">

        <div class="container" style="width:1200px;" >
     <form method="post" action="../product/ProductSearchList.do">
      <div class="container" style=" width: 430px; display: flex; justify-content: space-between; align-items: flex-start; margin-left:0px;">
    
       
        <select id="searchOptions" name="sct">
            <option value="전체" ${sct eq "전체"?"selected":""}>전체</option>
            <option value="사료" ${sct eq "사료"?"selected":""}>사료</option>
            <option value="간식" ${sct eq "간식"?"selected":""}>간식</option>
             <option value="배변/위생" ${sct eq "배변/위생"?"selected":""}>배변/위생</option>
            <option value="목욕/미용" ${sct eq "목욕/미용"?"selected":""}>목욕/미용</option>
            <option value="장난감" ${sct eq "장난감"?"selected":""}>장난감</option>
             <option value="건강관리" ${sct eq "건강관리"?"selected":""}>건강관리</option>
            <option value="식기" ${sct eq "식기"?"selected":""}>식기</option>
            <option value="산책/이동장" ${sct eq "산책/이동장"?"selected":""}>산책/이동장</option>
            <option value="하우스/울타리" ${sct eq "하우스/울타리"?"selected":""}>하우스/울타리</option>
            <option value="의류/악세서리" ${sct eq "의류/악세서리"?"selected":""}>의류/악세서리</option>
        </select>
   

    <div style="width:330px;">
        <div class="blog__sidebar__search" style=" width: 300px; margin-right: 500px;">
           
                <input type="text" placeholder="Search..." name="ss" value="${ss eq null?"":ss }" style="height:40px; width:230px;">
                <button type="submit"><span class="icon_search"></span></button>
            </form>
        </div>
    </div>
</div>
      <jsp:include page="ProductCategory.jsp"></jsp:include>
      <div class="row">
      
      
      <jsp:include page="${product_jsp }"></jsp:include>
      
      
       </div>
       
      

  </div>
    </section>
</body>
</html>