<?php
include_once('config.php');

$query = "SELECT * FROM schedules ORDER BY date ASC";
$result = mysqli_query($connection, $query);
$array_data = array();

while($schedule = mysqli_fetch_assoc($result))
{
  $array_data[]=$schedule;
}

header('Content-type: text/javascript');
echo json_encode($array_data, JSON_PRETTY_PRINT);
?>
