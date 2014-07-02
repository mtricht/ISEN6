<div class="section">
    <div class="container">
    	<div class="row">
			<applet code="isen/RfidApplet" archive="{{ url('jar/rfid.jar') }}" id="RfidApplet" name="RfidApplet" 
			width="200" height="200" scriptable="true">
				<param name="key" value="{{ privateKey|trim }}" />
				Please install Java.
			</applet>
			<form action="post">
				<input type="hidden" name="id" value="{{ id }}" />
				<input type="hidden" name="private_key" value="{{ privateKey|trim }}" />
				<input type="hidden" id="RfidUUID" name="uuid" />
				<div class="form-group">
					<input id="AcceptButton" type="submit" value="Accept" class="form-control">
				</div>
			</form>
		</div>
	</div>
</div>