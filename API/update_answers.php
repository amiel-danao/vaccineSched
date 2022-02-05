<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	require_once('config.php');

	$answers = $_POST['answers'];
	$user_id = $_POST['user_id'];
        $appo_id = $_POST['appo_id'];
	$answers_checklist = $_POST['answers_checklist'];
        $answers_screening = $_POST['answers_screening'];
	
	$getdata = mysqli_query($connection, "select * from answers where user_id='$user_id' AND appo_id='$appo_id");
	$rows = mysqli_num_rows($getdata);	
	
	if($rows > 0) 
	{
		$query = "UPDATE `answers` SET `answer_checklist` = '$answers_checklist' WHERE `user_id` = '$user_id' AND `appo_id`='$appo_id" ";
	} else {
		$query = "INSERT INTO answers(`user_id`, `answer_checklist`, `answer_screening`, `appo_id`) VALUES('$user_id', '$answers_checklist', '$answers_screening', '$appo_id'  )";
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
