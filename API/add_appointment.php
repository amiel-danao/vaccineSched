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

	$insert = "INSERT INTO `appointment` (`firstname`, `lastname`, `phonenumber`, `appo_date`, `appo_time`, `vaccine`, `user_id`, `nurse`, `place`, `email`, `status`)
																	
	VALUES ('$firstname', '$lastname', '$phonenumber', '$appo_date', '$appo_time', '$vaccine', '$user_id', '$nurse', '$place', '$email', '$status')";
										
										 
	$exeinsert = mysqli_query($connection, $insert);
	$response;

	if($exeinsert) {
		$response = "OK";
	} else {
		$response = mysqli_error($connection);
	}

	mysqli_free_result($exeinsert);
	header('Content-type: text/javascript');
	echo $response;
?>