<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" >
		<title>List ToDo Page</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
			<a class="navbar-brand m-1" href="https://www.google.com/">Google</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
				</ul>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>	
		</nav>
			
		<div class="container">
			<h1>Your ToDo</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
						<th></th>
						<th></th>
		
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="delete-todo?idDelete=${todo.id}" class="btn btn-warning">Delete</a></td>
							<td><a href="update-todo?idUpdate=${todo.id}" class="btn btn-success">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
		<script src="/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
	</body>
</html>