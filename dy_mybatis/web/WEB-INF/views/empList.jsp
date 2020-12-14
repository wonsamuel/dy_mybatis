<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
	#search-container{
		margin-left:auto;
		margin-right:auto;
	}
	
	table{
		margin-left:auto;
		margin-right:auto;
		border:1px solid; 
		border-collapse:collapse;
	}
	table th,table td{
	        border:1px solid;
	        padding:5px;
	        line-height: 2em; /*input태그로 인해 cell이 높이가 길어져 border 두줄현상방지 */
	    }
	h3{
		margin-left:auto;
		margin-right:auto;
		width:200px;
	}
</style>
</head>
<body>
	<div id="search-container">
	<form action="${pageContext.request.contextPath }/searchKeyList" method="post">
		<table>
			<tr>
				<td colspan="2">
					<select name="searchType" style="height:30px">
						<option value="" disabled selected>검색타입</option>
						<option value="emp_id" <%-- <c:if test='${param.searchType eq "emp_id"}'>selected</c:if> --%>>사원번호</option>
						<option value="emp_name" <%-- <c:if test='${param.searchType eq "emp_name"}'>selected</c:if> --%>>사원이름</option>
						<option value="email" <%-- <c:if test='${param.searchType eq "email"}'>selected</c:if> --%>>이메일</option>
						<option value="phone" <%-- <c:if test='${param.searchType eq "phone"}'>selected</c:if> --%>>전화번호</option>
					</select>
					<input name="searchKeyword" type="text" style="height:25px"<%--  value="${param.searchKeyword }" --%>/>
				</td>
			</tr>
			<tr>
				<th>성별</th>
					<td>
						<input type="radio" name="gender" value="남" id="gender0">
						<label for="gender0">남</label>
						<input type="radio" name="gender" value="여" id="gender1">
						<label for="gender1">여</label>
					</td>
			</tr>
			<tr>
				<th>급여</th>
				<td>
					<input type="number" name="salary" min="0" step="500000"/>
					<input type="radio" name="salary_le_ge" id="salary_ge" value="ge">
					<label for="salary_ge">이상</label>
					<input type="radio" name="salary_le_ge" id="salary_le" value="le">
					<label for="salary_le">이하</label>
				</td>
			</tr>
			<tr>
				<th>직급</th>
				<td>
					<input type="checkbox" name="job_code" id="J1" value="J1"/>
					<label for="J1">대표</label>
					<input type="checkbox" name="job_code" id="J2" value="J2"/>
					<label for="J2">부사장</label>
					<input type="checkbox" name="job_code" id="J3" value="J3"/>
					<label for="J3">부장</label>
					<br />
					<input type="checkbox" name="job_code" id="J4" value="J4"/>
					<label for="J4">차장</label>
					<input type="checkbox" name="job_code" id="J5" value="J5"/>
					<label for="J5">과장</label>
					<input type="checkbox" name="job_code" id="J6" value="J6"/>
					<label for="J6">대리</label>
					<br />
					<input type="checkbox" name="job_code" id="J7" value="J7"/>
					<label for="J7">사원</label>
				</td>	
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="검색" style="height:30px"/>
				</td>
			</tr>
		</table>
	</form>
		<h3>사원 전체 조회</h3>
			<c:if test="${not empty list }">
			<table>
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>주민번호</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>부서코드</th>
				<th>직급코드</th>
				<th>급여레벨</th>
				<th>급여</th>
				<th>보너스율</th>
				<th>매니져사번</th>
				<th>입사일</th>
				<th>성별</th>
			</tr>
			<c:forEach items="${list }" var="e">
				<tr>
					<td>${e['EMP_ID']}</td>
					<td>${e['EMP_NAME']}</td>
					<td>${e['EMP_NO']}</td>
					<td>${e['EMAIL']}</td>
					<td>${e['PHONE']}</td>
					<td>${e['DEPT_CODE']}</td>
					<td>${e['JOB_CODE']}</td>
					<td>${e['SAL_LEVEL']}</td>
					<td><fmt:formatNumber value="${e['SALARY']}" type="currency"/>원</td>
					<td><fmt:formatNumber value="${e['BONUS']}" type="percent"/></td>
					<td>${e['MANAGER_ID']}</td>
					<td><fmt:formatDate value="${e['HIRE_DATE']}" pattern="yyyy년 MM월 dd일"/></td>
					<td></td>
				</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty list }">
			<h3>조회된 회원이 없습니다!</h3>
		</c:if>
	</div>
	<div id="page-container">
		${pageBar }
	</div>
</body>
</html>