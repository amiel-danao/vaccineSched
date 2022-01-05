<?php
error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));
include_once('config.php');

$nim = $_GET['nim'];
$name = $_GET['name'];
$class = $_GET['class'];

$insert = "INSERT INTO usersinfo (mhs_nim, 
                                   mhs_name, 
                                   mhs_class)
                            VALUES (
                                   '$nim',
                                   '$name', 
                                   '$class')";

$exeinsert = mysqli_query($connection, $insert);
$response = array();

if($exeinsert) {
  $response['status_kode'] =1;
  $response['status_pesan'] = "Success! Data Inserted";
} else {
  $response['status_kode'] =0;
  $response['status_pesan'] = "Failed! Data Not Inserted";
}

header('Content-type: text/javascript');
echo json_encode($response, JSON_PRETTY_PRINT);
?>