$(document).ready(function(){
	// Accept button for a new user.
	$('#AcceptButton').click(function(e){
		if (RfidApplet.uuid == null) {
			alert("Something went wrong.");
			e.preventDefault();
		} else {
			$('#RfidUUID').val(RfidApplet.uuid);
		}
	});
});