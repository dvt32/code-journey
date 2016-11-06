<?php
	$day = date("Y-M-D");
	echo "$day" . " year <br />";
	$dd = substr($day, 9, 3);
	
	switch ($dd) {
		case 'Mon':
			echo "Today is Monday"; 
			break;
		case 'Tue':
			echo "Today is Tuesday";
			break;
		case 'Wed':
			echo "Today is Wednesday";
			break;
		case 'Thu':
			echo "Today is Thursday";
			break;
		case 'Fri':
			echo "Today is Friday";
			break;
		case 'Sat':
			echo "Today is Saturday";
			break;
		case 'Sun':
			echo "Today is Sunday";
			break;
		default:
			echo "Unknown day!";
	}
?>
