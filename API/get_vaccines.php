<?php

	include_once('config.php');

	$query = "SELECT * FROM vaccines WHERE quantity > 0";
	$result = mysqli_query($connection, $query);
	$vaccines = array();
	
	while($vaccine = mysqli_fetch_assoc($result))
	{
	  $vaccines[] = $vaccine;
	}

	mysqli_free_result($result);
	header('Content-type: text/javascript');
	echo json_encode($vaccines, JSON_PRETTY_PRINT);

?>