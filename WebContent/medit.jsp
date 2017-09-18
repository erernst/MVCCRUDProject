<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Emazes</title>
<link rel="stylesheet" href="mazes.css">

</head>
<body>
  <h2>Corn Mazes</h2>
<link rel="stylesheet" href="mastercss.css">
</head>
<body class="bodyclass">
    <div class="jsp-container">

  <form action="editMaze.do" method="POST">
		Name of Maze to Edit:
		<input type="text" name="oldname" value="${maze.name}" readonly/><br/>
		New Name:
		<input type="text" name="name" value="${maze.name}"/><br/>
		State:
		<input type="text" name="state" value="${maze.state}"/><br/>
		City: 
		<input type="text" name="city" value="${maze.city}"/><br/>
		Map: 
		<input type="text" name="url" value="${maze.course}"/><br/>
		<input type="submit" value="Edit Maze" />
	</form>
		
    </div>
</body>
</html>