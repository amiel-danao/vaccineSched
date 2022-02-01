<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	include 'config.php';

	if(!isset($_POST['email']) || !isset($_POST['password'])){
		echo "Invalid email or Password Please Try Again !";
		return;
	}

	$email = $_POST['email'];
	$password = $_POST['password'];

	$Sql_Query = "select * from usersinfo where email = '$email'";
	$result = mysqli_query($connection, $Sql_Query);
	$array_data = mysqli_fetch_array($result, MYSQLI_ASSOC);
	if (isset($array_data)) {
		$correct_password = $array_data['password'];
		if (password_verify($password, $correct_password)) {
		echo json_encode($array_data, JSON_PRETTY_PRINT);
		} else {
			echo "Invalid email or Password Please Try Again!!!";
		}
		return;
	} else {
		echo "Invalid email or Password Please Try Again ! no record";
		return;
	}
	mysqli_free_result($result);
} else {
	echo "Check Again";
}
?>