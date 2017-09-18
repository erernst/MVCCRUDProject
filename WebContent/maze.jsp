<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Emazes</title>
<link rel="stylesheet" href="mastercss.css">
</head>
<body>
	<h2>Corn Mazes</h2>
	<link rel="stylesheet" href="mazes.css">
</head>
<body class="bodyclass">
	<div class="jsp-container">


		<div class="jsp-pres-info">
			<form action="edit.do" method="GET">
			
					<a href="edit.do?maze=${maze.name}">Edit</a><br /> <img
						src="${maze.course}" class="IMG">
					<p class="emazename">${maze.name}</p>
					<p>${maze.city},${maze.state}</p>

					<br> <a href="remove.do?maze=${maze.name}">Remove</a>

		</div>
		<div class="form">
			<a href="index.jsp">Home</a>
		</div>
	</div>
</body>
</html>