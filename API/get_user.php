<?php
error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
include_once('config.php');

$email = $_POST['email'];

$select = "SELECT * FROM `usersinfo` WHERE email='$email'";
$exeselect = mysqli_query($connection, $select);

$response = array();

if(mysqli_num_rows($exeselect) > 0) {  
	while($userinfo = mysqli_fetch_assoc($exeselect))
	{
	  $response[0]=$userinfo;
	}
	header('Content-type: text/javascript');
	echo json_encode($response[0], JSON_PRETTY_PRINT);
} else {
	echo "User doesn't exist";
}

mysqli_free_result($exeselect);

?>