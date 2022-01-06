<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	include 'config.php';

	if(!isset($_POST['email']) || !isset($_POST['password'])){
		echo "Invalid Username or Password Please Try Again !";
		return;
	}

	$email = $_POST['email'];
	$password = $_POST['password'];

	$Sql_Query = "select * from usersinfo where email = '$email' and password = '$password' ";
	$result = mysqli_query($connection, $Sql_Query);
	$array_data = mysqli_fetch_array($result, MYSQLI_ASSOC);
	if (isset($array_data)) {
		echo json_encode($array_data, JSON_PRETTY_PRINT);
		return;
	} else {
		echo "Invalid Username or Password Please Try Again !";
		return;
	}
	mysqli_free_result($result);
} else {
	echo "Check Again";
}
?>