<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	require_once('config.php');

	$answers = $_POST['answers'];
	$user_id = $_POST['user_id'];
	$column = $_POST['category'];
	
	$getdata = mysqli_query($connection, "select * from answers where user_id='$user_id'");
	$rows = mysqli_num_rows($getdata);	
	
	if($rows > 0) 
	{
		$query = "UPDATE `answers` SET `$column` = '$answers' WHERE `user_id` = '$user_id'";
	} else {
		$query = "INSERT INTO answers(`user_id`, `$column`) VALUES('$user_id', '$answers')";
	}
										 
	$exequery = mysqli_query($connection, $query);
	$response;
	
	if($exequery)
	{
		$response = "User updated Successfully";
	} else {
		$response = "Updated Failed" . mysqli_error($connection);
	}
	
	mysqli_free_result($exequery);
	header('Content-type: text/javascript');
	echo $response;
?>
