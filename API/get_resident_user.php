<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	include_once('config.php');

	$card_id = $_POST['card_id'];
	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
	$suffix = $_POST['suffix'];

	$select = "SELECT * FROM `resident_list` WHERE `brg_id_number`='$card_id' AND `firstname`='$firstname' AND `lastname`='$lastname' AND `suffix`='$suffix'";
	$exeselect = mysqli_query($connection, $select);

	if(mysqli_num_rows($exeselect) > 0) {
		echo "OK";
	} else {
		echo "Resident doesn't exist!";
	}

	mysqli_free_result($exeselect);

?>