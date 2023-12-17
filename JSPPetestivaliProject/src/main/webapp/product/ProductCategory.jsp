<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
   
    .selected{
    color: blue;
    }
    </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-lg-3 col-md-5"  style="float:left; margin-right:0px; margin-top:100px; width:200px;">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>카테고리</h4>
                            <ul>
                                <li><a href="ProductList.do?ct=전체" class="${ct eq '전체' ? 'selected' : ''}">전체(${cateNumList[0] })</a></li>
                                
                                <li><a href="ProductList.do?ct=간식" class="${ct eq '간식' ? 'selected' : ''}">간식(${cateNumList[1] })</a></li>
                                <li><a href="ProductList.do?ct=배변/위생" class="${ct eq '배변/위생' ? 'selected' : ''}">배변/위생(${cateNumList[2] })</a></li>
                                <li><a href="ProductList.do?ct=목욕/미용" class="${ct eq '목욕/미용' ? 'selected' : ''}">목욕/미용(${cateNumList[3] })</a></li>
                                <li><a href="ProductList.do?ct=사료" class="${ct eq '사료' ? 'selected' : ''}">사료(${cateNumList[4] })</a></li>
                                <li><a href="ProductList.do?ct=장난감" class="${ct eq '장난감' ? 'selected' : ''}">장난감(${cateNumList[5] })</a></li>
                                <li><a href="ProductList.do?ct=건강관리" class="${ct eq '건강관리' ? 'selected' : ''}">건강관리(${cateNumList[6] })</a></li>
                                <li><a href="ProductList.do?ct=식기" class="${ct eq '식기' ? 'selected' : ''}">식기(${cateNumList[7] })</a></li>
                                <li><a href="ProductList.do?ct=산책/이동장" class="${ct eq '산책/이동장' ? 'selected' : ''}"}">산책/이동장(${cateNumList[8] })</a></li>
                                <li><a href="ProductList.do?ct=하우스/울타리" class="${ct eq '하우스/울타리' ? 'selected' : ''}">하우스/울타리(${cateNumList[9] })</a></li>
                                <li><a href="ProductList.do?ct=의류/악세서리" class="${ct eq '의류/악세서리' ? 'selected' : ''}">의류/악세서리(${cateNumList[10] })</a></li>
                                
                            </ul>
                        </div>
                        
                        
                      
                     
                    </div>
                </div>
</body>
</html>