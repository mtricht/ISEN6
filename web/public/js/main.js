function redirect (url) {
	window.location.href = baseUrl + url
}

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
	$('#AcceptForm').submit(function(){
		// Open PDF in new window.
		setTimeout(function(){redirect('admin');}, 500);
		$(this).attr('target', '_blank');
	});
});