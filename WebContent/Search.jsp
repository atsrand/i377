<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Part 3</title>
<style type="text/css">
<!--
@import url("/myProject/style.css");
-->
</style>
</head>
<body>
	<ul id="menu">
		<li><a href="Search" id="menu_Search">Otsi</a></li>
		<li><a href="Add" id="menu_Add">Lisa</a></li>
		<li><a href="ManageData?do=clear_data" id="menu_ClearData">Tühjenda</a></li>
		<li><a href="ManageData?do=insert_data" id="menu_InsertData">Sisesta
				näidisandmed</a></li>
	</ul>
	<br />
	<br />
	<br />
	<form method="post" action="Search">
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
				<c:forEach var="unit" items="${searchResult}">
					<tr>
						<td>
							<div id="row_${unit.code}">
								${unit.name}
							</div>
						</td>
						<td>${unit.code}</td>
						<td>
						<a id="delete_${unit.code}" href="ManageData?do=delete&id=${unit.id}">Kustuta</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
