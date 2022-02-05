<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	require_once('config.php');

	$feedback = $_POST['feedback'];
	$appo_id = $_POST['appo_id'];
	
	$getdata = mysqli_query($connection, "select * from feedbacks where appo_id='$appo_id'");
	$rows = mysqli_num_rows($getdata);	
	
	if($rows > 0) 
	{
		$query = "UPDATE `feedbacks` SET `feedback` = '$feedback' WHERE `appo_id` = '$appo_id'";
	} else {
		$query = "INSERT INTO feedbacks(`appo_id`, `feedback`) VALUES('$appo_id', '$feedback')";
	}
										 
	$exequery = mysqli_query($connection, $query);
	$response;
	
	if($exequery)
	{
		$response = "OK";
	} else {
		$response = "Updated Failed" . mysqli_error($connection);
	}
	
	mysqli_free_result($exequery);
	header('Content-type: text/javascript');
	echo $response;
?>
