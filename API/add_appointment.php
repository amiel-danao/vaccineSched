<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	include_once('config.php');

	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
	$phonenumber = $_POST['phonenumber'];
	$appo_date = $_POST['appo_date'];
	$appo_time = $_POST['appo_time'];
	$vaccine = $_POST['vaccine'];
	$user_id = $_POST['user_id'];
	$nurse = $_POST['nurse'];
	$place = $_POST['place'];
	$email = $_POST['email'];
	$status = $_POST['status'];
	$scheduleId = $_POST['scheduleId'];
	$capacity = $_POST['capacity'];

	$insert = "INSERT INTO `appointment` (`firstname`, `lastname`, `phonenumber`, `appo_date`, `appo_time`, `vaccine`, `user_id`, `nurse`, `place`, `email`, `status`)
																	
	VALUES ('$firstname', '$lastname', '$phonenumber', '$appo_date', '$appo_time', '$vaccine', '$user_id', '$nurse', '$place', '$email', '$status')";
										
										 
	$exeinsert = mysqli_query($connection, $insert);
	$response = "-1";

	if($exeinsert) {
		$response = mysqli_insert_id($connection);
	} else {
		$response = "-1";
		return;
	}
	
	$deduct = "UPDATE schedules SET capacity='$capacity'
				WHERE id='$scheduleId'";
				
	$exededuct = mysqli_query($connection, $deduct);
	
	if($exededuct) {
		
	} else {
		$response = "-1";
		return;
	}

	mysqli_free_result($exeinsert);
	mysqli_free_result($exededuct);
	header('Content-type: text/javascript');
	echo $response;
?>
