<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
  html { height: 100% }
  body { height: 100%; margin: 0; padding: 0 }
  #map_canvas { height: 100% }
</style>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBcsmPcqniXkaGVEevm608o9HzL6VnYT3Q&callback=initialize"></script>
<script type="text/javascript">
    var parliament = new google.maps.LatLng(-1.262152, 36.809073);
var marker;
    
  function initialize(){
    var myOptions = {
      zoom: 17,
      center: parliament ,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
    
     var marker = new google.maps.Marker({
      position: parliament, 
      map: map, 
      title:"Orac ltd"
  });   
  }

</script>
</head>
<body onload="initialize()">
  <div id="map_canvas" style="width:100%; height:100%"></div>
</body>
</html>