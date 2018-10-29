<!DOCTYPE html>
<html>
	<head>
		<title>Yahoo!!</title>
	</head>
	<body>
		<p><font color="red">${errorMessage}</font></p>
		<form action="/login" method="post">
			Enter your name: <input type="text" name="name" />
			Password: <input type="password" name="password" />
			<input type="submit" value="Login" />
		</form>
	</body>
</html>