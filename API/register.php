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

$insert = "INSERT INTO usersinfo (firstname, 
                                   lastname, 
                                   email,
									city,
									baranggay,
									phone,
									password)
                            VALUES (
                                   '$firstname',
                                   '$lastname',
                                   '$email', 
                                   '$city',
									'$brgy'
									'$phone'
									'$password'
									)";

$exeinsert = mysqli_query($connection, $insert);
$response = array();

if($exeinsert) {
  $response['status_kode'] =1;
  $response['status_pesan'] = "Success! Data Inserted";
} else {
  $response['status_kode'] =0;
  $response['status_pesan'] = "Failed! Data Not Inserted";
}

mysqli_free_result($exeinsert);
header('Content-type: text/javascript');
echo json_encode($response, JSON_PRETTY_PRINT);
?>