<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="mazes.css">
<title>Corn Mazes</title>
</head>
<body>
	<h2>Add Corn Maze</h2>
	<form action="NewMaze.do" method="POST">
		Name:
		<input type="text" name="name" value="Maze Name"/><br/>
		State:
		<input type="text" name="state" value="State"/><br/>
		City: 
		<input type="text" name="city" value="City"/><br/>
		Map: 
		<input type="text" name="url" value="https://pbs.twimg.com/profile_images/463936577946005504/Bgj5syYS.jpeg"/><br/>
		<input type="submit" value="Add Maze" />
	</form>
</body>
</html>
