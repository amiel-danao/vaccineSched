<?php
	error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
	require_once('config.php');

	$user_id = $_POST['user_id'];

	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
	$birthday = null;
	$bdayText = "";
	if(isset($_POST['birthday'])){
		$birthday = $_POST['birthday'];
		$bdayText = "dateofbirth='$birthday',";
	}
	
	$birthplace = $_POST['birthplace'];
	$city = $_POST['city'];
	$brgy = $_POST['brgy'];
	$sex = $_POST['sex'];
	$weight = $_POST['weight'];
	$height = $_POST['height'];
	$phone = $_POST['phone'];
	$mothersname = $_POST['mothersname'];
	$fathersname = $_POST['fathersname'];

	$getdata = mysqli_query($connection, "SELECT * FROM usersinfo WHERE user_id='$user_id'");
	$rows = mysqli_num_rows($getdata);

	$update = "UPDATE usersinfo SET  firstname='$firstname', 
									 lastname='$lastname', 
									 ".$bdayText."
									 placeofbirth='$birthplace',
									 city='$city',
									 baranggay='$brgy',
									 sex='$sex',
									 birthweight='$weight',
									 birthheight='$height',
									 phone='$phone',
									 mothersname='$mothersname',
									 fathersname='$fathersname'
									 WHERE user_id='$user_id'";
									 
	$exequery = mysqli_query($connection, $update);
	$response;

	if($rows > 0) 
	{
		if($exequery)
		{
			$response = "User updated Successfully";
		} else {
			$response = "Updated Failed";
		}
	} else {
		$response = "Updated Failed, No existing user data";
	}

	mysqli_free_result($getdata);
	mysqli_free_result($exequery);
	header('Content-type: text/javascript');
	echo $response;
?>
