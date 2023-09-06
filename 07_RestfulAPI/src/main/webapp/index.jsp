<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous"
/>
<style>
	h1 {
		margin-top: 70px;
		text-align: center;
	}
	
	.table {
		margin-top: 30px;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>휴대전화 목록</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>모델 번호</th>
					<th>모델 이름</th>
					<th>가격</th>
					<th>제조사명</th>
				</tr>
			</thead>
			<tbody id="list">
			</tbody>
		</table>
		<h1>휴대전화 정보</h1>
		<form id="phoneFrm">
			모델 번호 : <input type="text" name="num" id="num" class="form-control"><br>
			모델명 : <input type="text" name="model" id="model" class="form-control"><br>
			가격 : <input type="text" name="price" id="price" class="form-control"><br>
			제조사 :
			<select id="vcode" name="vcode" class="form-control">
				<option value="10">삼성</option>
				<option value="20">애플</option>
			</select>
			<br>
			<input type="button" value="추가하기" id="insert">
			<input type="button" value="수정하기" id="update">
			<input type="button" value="삭제하기" id="delete">
		</form>
	</div>
	
	<script>

		window.onload = listLoad();	

		function listLoad() {

			$.ajax({
				type : "get",
				url : "phone",
				dataType : 'json',

				success: function(data) {
					const list = eval(data);
					let resultHtml = '';
					for(let item of list) {
						resultHtml += "<tr>" +
							'<td class="num">'+ item.num + "</td>" +
							"<td>"+ item.model + "</td>" +
							"<td>"+ item.price + "</td>" +
							"<td>"+ item.company.vendor + "</td>" +
							"</tr>";
					}
					$('#list').html(resultHtml);
				},
				error : function() {
					console.log('시스템 상 에러 발생');
				}
			})
		}
		
		// 상세 조회
		$('#list').on('click', '.num', function() {
			const num = $(this).text();

			$.ajax({
				type : "get",
				url : "phone/"+num,
				dataType : 'json',

				success : function(data) {
					const list = eval(data);
					$('#num').val(list.num);
					$('#model').val(list.model);
					$('#price').val(list.price);
					$('#vcode').val(list.vcode);
				},

				error : function(data) {
					alert('조회 실패');
				}

			})

		})

		// 추가
		$('#insert').on('click', function() {

			// json 방식으로 전달

			const num = $('#num').val();
			const model = $('#model').val();
			const price = $('#price').val();
			const vcode = $('#vcode').val();

			let phone = {
				"num": num,
				"model": model,
				"price": price,
				"vcode": vcode
			}

			$.ajax({
				type : "post",
				url : "phone",
				data: JSON.stringify(phone),
				contentType: 'application/json',

				success : function(data) {
					listLoad();
				},

				error : function(data) {
					alert('추가 실패');
				}

			})

		});

		// 수정
		$('#update').on('click', function() {
			const num = $('#num').val();
			const model = $('#model').val();
			const price = $('#price').val();
			const vcode = $('#vcode').val();
			
			let phone = {
					"num": num,
					"model": model,
					"price": price,
					"vcode": vcode
				}

			$.ajax({
				type : "put",
				url : "phone", 
				data: JSON.stringify(phone),
				contentType: 'application/json',

				success : function(data) {
					listLoad();
				},
				
				error : function(data) {
					alert('수정 실패');
				}

			})

		});

		// 삭제
		$('#delete').on('click', function() {
			const num = $('#num').val();

			$.ajax({
				type : "delete",
				url : "phone/"+num,

				success : function(data) {
					listLoad();
					$('#num').val('');
					$('#model').val('');
					$('#price').val('');
					$('#vcode').val('');
				},
				
				error : function(e) {
					alert('삭제 실패');
				}

			})
		});
	</script>
</body>
</html>