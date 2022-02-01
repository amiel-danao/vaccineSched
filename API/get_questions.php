<?php
	include_once('config.php');
	
	$category = "checklist";
	if (isset($_GET['category'])) {
		$category = $_GET['category'];
	}	

	$query = "SELECT * FROM questions WHERE category = '$category'";
	$result = mysqli_query($connection, $query);
	$questions = array();

	while($question = mysqli_fetch_assoc($result))
	{
	  $questions[]=$question;
	}

	mysqli_free_result($result);
	header('Content-type: text/javascript');
	echo json_encode($questions, JSON_PRETTY_PRINT);
?>
