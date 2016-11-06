<!DOCTYPE html>
<html>
	<head>
		<title>My first PHP program</title>
		<meta charset="windows-1251">
	</head>
	<body>
		<p>
			Hi, 
			<?php 
				$firstName = "Alexander";
				$lastName = "Petrov";
				$title = "Mr.";
				print "$title $lastName, ";
			?>
			may I call you <?php print "$firstName"; ?>?
		</p>
	</body>
</html>
