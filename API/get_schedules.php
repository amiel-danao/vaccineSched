<?php
	include_once('config.php');

	date_default_timezone_set('Asia/Hong_Kong');

	$query = "SELECT * FROM schedules WHERE capacity > 0 AND NOW() < date ORDER BY date ASC";
	$result = mysqli_query($connection, $query);
	$schedules = array();

	while($schedule = mysqli_fetch_assoc($result))
	{
	  $schedules[]=$schedule;
	}

	mysqli_free_result($result);
	header('Content-type: text/javascript');
	echo json_encode($schedules, JSON_PRETTY_PRINT);
?>
