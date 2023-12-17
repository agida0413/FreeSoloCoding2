<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Petstival</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-image: url('굥.jpg');
      background-size: cover; /* 이미지가 창을 가득 채우도록 설정 */
      background-position: center; /* 이미지를 가운데로 정렬 */
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }
    .welcome-message {
      text-align: center;
      margin-bottom: 20px;
      background-color: rgba(255, 255, 255, 0.8); /* 폼에 투명한 배경 색상 추가 */
      padding: 20px;
      border-radius: 10px;
    }
    .welcome-message h2 {
      margin-bottom: 10px;
    }
    .return-btn {
      padding: 10px 20px;
      background-color: #3498db;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
      transition: background-color 0.3s ease;
    }
    .return-btn:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
  <div class="welcome-message">
    <h2>Petstival에 오신걸 환영합니다!!</h2>
    <p>이제 홈페이지를 마음껏 이용하실 수 있습니다!</p>
    <a href="../main/main.do" class="return-btn">홈으로</a>
  </div>
</body>
</html>




