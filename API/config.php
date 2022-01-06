<?php
 define('HOST', 'localhost');
 define('USER', 'id18222363_root2');
 define('PASS', 'Password123$');
 define('DB', 'id18222363_vaccineschedule');

 $connection = mysqli_connect(HOST, USER, PASS, DB) or die(mysqli_errno());
 
if (mysqli_connect_errno())
{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?>