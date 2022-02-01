<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	include_once('config.php');

	$user_id = $_POST['user_id'];
	$appo_date = $_POST['appo_date'];
	$appo_time = $_POST['appo_time'];
	$place = $_POST['place'];
	$vaccine = $_POST['vaccine'];

	$select = "SELECT * FROM `appointment` WHERE user_id='$user_id' AND vaccine='$vaccine' AND appo_date='$appo_date' AND appo_time='$appo_time' AND place='$place'";
	$exeselect = mysqli_query($connection, $select);

	if(mysqli_num_rows($exeselect) > 0) {  
		echo "Appointment already exist";
	} else {
		echo "Appointment doesn't exist";
	}

	mysqli_free_result($exeselect);

?>