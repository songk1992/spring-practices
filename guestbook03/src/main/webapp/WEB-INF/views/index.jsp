<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath }/assets/css/style.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>

	<br />

	<!-- 등록 구간 -->


	<!-- https://codepen.io/geoffyuen/pen/FCBEg -->
	<h1>RWD List to Table</h1>
	<form action="${pageContext.request.contextPath }/add" method="post">
		<table class="rwd-table">

			<tr>
				<th>이름</th>
				<th>비밀번호</th>
			</tr>
			<tr>
				<td><input type="text" name="name" value=""></td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" id="content"></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
		<table>
			<tr>
			<tr>

			</tr>

		</table>
	</form>

	<br />
	<br />

	<!-- 보여주기 + 삭제 구간 -->

	<c:forEach items='${list }' var='vo' varStatus='status'>
		<ul>
			<li>
				<table>
					<tr>
						<td>${status.count }</td>

						<td>${vo.name }</td>
						<td>${vo.datetime }</td>
						<td>
							<form action="${pageContext.request.contextPath }/deleteform"
								method="post">
								<input type='hidden' name='no' value='${vo.no }' /> <input
									type="submit" value="삭제">
							</form>
						</td>
					</tr>
					<tr>
						<td colspan=4>${vo.message }</td>
					</tr>
				</table>
			</li>
		</ul>
	</c:forEach>
	</div>
	</div>




</body>
</html>