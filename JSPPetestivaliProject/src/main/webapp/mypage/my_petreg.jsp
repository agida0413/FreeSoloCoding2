<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="../css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="../css/nice-select.css" type="text/css">
<link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="../css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">

</script>
<style type="text/css">

.petreg_input p {
	color: black;
}

p span {
	color: red;
}

.flex {
	display: flex;
	align-items: center; /* 세로 중앙 정렬을 위한 속성 */
}
.regul {
	display: flex;
	align-items: center;
}

.regul ul {
	margin: 0px 0 0 20px;
	float: right;
}

.regul li {
	list-style-type: none;
	color: grey;
}

.regul li span {
	color: red;
}

</style>


</head>
<body>

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">
			<div class="checkout__form">
				<div class="petreg_title col-lg-2" style="margin-left: 440px; text-align: center;" >
				<h4>마이펫 등록</h4>
				</div>
				<form method="post" action="my_petInsert.do"
					enctype="multipart/form-data">
					
					<div class="row">
						<div class="col-lg-8 col-md-6" style="margin-left: 360px;">

							<div class="col-lg-6">
								<div class="petreg_input" style="margin-bottom: 20px;">
									<p>
										마이펫 사진<span></span>
									</p>
									 <input type="file" name="upload" size=25 required id="petImageInput" accept="image/*">
     								   <img id="selectedPetImage" style="max-width: 100%; max-height: 200px; margin-top: 10px; display: none;">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="checkout__input">
									
									<input type="text" name="pet_name" placeholder="반려동물의 이름을 입력하세요" required>
								</div>
							</div>

							<div class="col-lg-6">
								<div class="checkout__input">
									
									<input type="text" name="pet_bday"
										placeholder="반려동물의 생년월일을 입력하세요" required>
								</div>
							</div>
							<div class="col-lg-6" >
								<label for="acc">
									<p>
										성별<span>*</span>
									</p> <input type="radio" name="pet_gender" id="male" value="남아"
									required> 남아 <span class="radio" style="margin-right: 10px;"></span>
									<input type="radio" name="pet_gender" id="female" value="여아" required>
									여아 <span class="radio"></span>
								</label>
							</div>
							<div class="col-lg-6">
								<label for="acc"> <input type="checkbox"
									name="pet_neutralize" id="neutralize" required> 중성화여부 <span
									class="checkmark"></span>
								</label>
							</div>
							<div class="col-lg-6" style="margin-top: 10px;">
								<div class="checkout__input">
									
									<input type="text" name="pet_weight" placeholder="몸무게(kg)">
								</div>
							</div>
							<div class="regul">
							<ul>
									<li><span>*</span>은 필수 입력 사항입니다.</li>
								</ul>
							</div>
								<div class="flex col-lg-6">
								<button type="submit" class="site-btn"
									style="margin: 20px 0 0 50px;">등록</button>
							    <button type="button" class="site-btn" style="margin: 20px 0 0 20px;"
							     onclick="javascript:history.back()">취소</button>
							</div>
						</div>
						</div>
						</form>
					</div>
		</div>
	</section>
	<!-- Checkout Section End -->

	<!-- Js Plugins -->
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.nice-select.min.js"></script>
	<script src="../js/jquery-ui.min.js"></script>
	<script src="../js/jquery.slicknav.js"></script>
	<script src="../js/mixitup.min.js"></script>
	<script src="../js/owl.carousel.min.js"></script>
	<script src="../js/main.js"></script>



</body>
</html>