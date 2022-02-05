<?php
error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
include_once('config.php');

$firstname = $_POST['firstname'];
$lastname = $_POST['lastname'];
$email = $_POST['email'];
$city = $_POST['city'];
$brgy = $_POST['brgy'];
$phone = $_POST['phone'];
$password = $_POST['password'];
$brgy_id = $_POST['brgy_id'];

$hashed_password = password_hash($password, PASSWORD_DEFAULT);

$insert = "INSERT INTO `usersinfo` (`user_id`, `dateofbirth`, `placeofbirth`,  `mothersname`, `fathersname`, `birthheight`, `birthweight`, `sex`, `firstname`, `lastname`, `city`, `baranggay`, `email`, `password`, `phone`, `brg_id_number`)
                            									
VALUES (NULL, NULL, '', '', '', '0', '0', '', '$firstname', '$lastname', '$city', '$brgy', '$email', '$hashed_password', '$phone', '$brgy_id')";
									
									 

$exeinsert = mysqli_query($connection, $insert);
$response = array();

if($exeinsert) {
	$exeinsert = mysqli_query($connection, "SELECT * FROM `usersinfo` WHERE email='$email'");
  
	while($schedule = mysqli_fetch_assoc($exeinsert))
	{
	  $response[0]=$schedule;
	}
} else {
  $response[0] = "Failed! Data Not Inserted";
}

mysqli_free_result($exeinsert);
header('Content-type: text/javascript');
echo json_encode($response[0], JSON_PRETTY_PRINT);
?>
