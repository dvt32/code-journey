<?php
	$cars[1] = "Lada";
	$cars[] = "Ford";
	$cars[4] = "Mercedes";
	
	
	// Print all elements
	for ($i = 0; $i < 10; ++$i) {
		echo $cars[$i] . "<br />";
	}
	
	echo "<br />";
	
	// Print only loaded elements
	for ($i = 0; $i < 10; ++$i) {
		if (isSet($cars[$i])) {
			echo $cars[$i] . "<br />";
		}
	}
?>
