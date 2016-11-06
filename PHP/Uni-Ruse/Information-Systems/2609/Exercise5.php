<?php
	// Load elements
	$fruit[1] = 5.6;
	$fruit[7] = 'banana';
	$fruit[] = 'pear';
	
	echo "Showing first 9 elements of the array <br />";
	for ($i = 1; $i <= 9; ++$i) {
		if (empty($fruit[$i])) {
			echo "fruit[$i] = <br />";
		}
		else {
			echo "fruit[$i] = $fruit[$i] <br />";
		}
	}
	
	echo "Showing only the loaded elements of the array <br />";
	for ($i = 1; $i <= 9; ++$i) {
		if (isSet($fruit[$i])) {
			echo "fruit[$i] = $fruit[$i] <br />";
		}
	}
	
	$fruitSize = sizeof($fruit);
	echo "Using sizeof() <br /> The number of elements is => $fruitSize <br />";
	
	echo '<p style="color: blue;">Deleting element $fruit[7]</p> <br />';
	unset($fruit[7]);
	
	$fruitSize = count($fruit);
	echo "Using count() <br /> The number of elements is => $fruitSize <br />";
	
	$state = array(
	'Bulgaria' => 'Sofia', 
	'England' => 'London', 
	'France' => 'Paris', 
	'Germany' => 'Berlin'
	);
	foreach ($state as $key => $value) {
		echo 'The capital of <span style="color: red;"><strong>' . $key . '</strong></span> is <span style="color: green;"><strong>' . $value . '</strong></span> <br />';
	}
	
?>
