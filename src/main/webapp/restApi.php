<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title></title>
</head>
<body>
<div style="padding:10px;">
<h5>List of Companies</h5>
<?php
$request = file_get_contents("http://localhost:8080/TripTicket/trip/*");
$jsonValues = json_decode($request,true);

$output = "<table class=\"table table-striped\"><thead><th>ID</th><th>Arrival Time</th><th>Depature Time</th><th>Price</th><th>Route</th></thead>";
foreach ($jsonValues as $trip) {
	$output .= "<tr><td>".$trip["id"]."</td><td>".$trip["arrivalTime"]."</td>";
	$output .= "<td>".$trip["depatureTime"]."</td><td>".$trip["price"]."</td>";
	$output .= "<td>".$trip["route"]."</td></tr>";
}
$output .= "</ul>";

echo $output;

?>	
</div>
    <a class="btn btn-primary" href="javascript:window.print()">Print Report</a> 
</body>
</html>

