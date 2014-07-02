$(document).ready(function(){
	// Accept button for a new user.
	$('#AcceptButton').click(function(e){
		e.preventDefault();
		alert(RfidApplet.uuid);
		if (RfidApplet.uuid == null) {
			alert("Something went wrong.");
		} else {
			$('#RfidUUID').val(RfidApplet.uuid);
			$('#AcceptButton').submit();
		}
	});
});