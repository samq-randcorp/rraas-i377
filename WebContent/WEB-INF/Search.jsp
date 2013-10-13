<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset=utf-8>
<title>Search</title>

</head>
<body>

<%@ include file="Menu.jsp" %>

	<form method="get" action="Search">
		<input name="searchString" id="searchStringBox" value="" /> <input
			type="submit" id="filterButton" value="Filtreeri" /> <br /> <br />
			
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Nimi</th>
					<th scope="col">Kood</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="unit" items="${units}">
					<tr>
						<td>
							<div id="row_${unit.code}"><c:out value="${unit.name}"></c:out></div>
						</td>
						<td>${unit.code}</td>
						<td><a href="Search?do=delete&id=${unit.id}"
							id="delete_${unit.code}">Kustuta</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</form>
</body>
</html>