<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	include_once('config.php');

	$user_id = $_POST['user_id'];

	$select = "SELECT * FROM `history` WHERE user_id='$user_id'";
	$exeselect = mysqli_query($connection, $select);

	$histories = array();
	
	while($history = mysqli_fetch_assoc($exeselect))
	{
	  $histories[] = $history;
	}

	mysqli_free_result($exeselect);
	header('Content-type: text/javascript');
	echo json_encode($histories, JSON_PRETTY_PRINT);

?>