<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="mazes.css">
<title>Corn Mazes</title>
<link rel="stylesheet" href="mazes.css">
</head>
<body>
	<h2>List of Corn Mazes</h2>
	<a href="newMaze.jsp">Add Maze</a>

	<c:forEach items="${mazes}" var="maze">
			<div><a href="view.do?maze=${maze.name}">${maze.name}</a><br/>
			<img src="${maze.course}" class="thumbIMG">
			<br/>
		</div>
	</c:forEach>

	<br/>
	</select>
</body>
</html>
