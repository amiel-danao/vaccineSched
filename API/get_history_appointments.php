<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	include_once('config.php');

	$user_id = $_POST['user_id'];
	date_default_timezone_set('Asia/Hong_Kong');
	  
	$now = new DateTime();
	$today = $now->format('Y-m-d');

	$select = "SELECT * FROM `appointment` WHERE user_id='$user_id' AND appo_date < CURDATE()";
	$exeselect = mysqli_query($connection, $select);

	$appointments = array();
	
	while($appointment = mysqli_fetch_assoc($exeselect))
	{
	  $appointments[] = $appointment;
	}

	mysqli_free_result($exeselect);
	header('Content-type: text/javascript');
	echo json_encode($appointments, JSON_PRETTY_PRINT);

?>