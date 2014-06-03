<!-- Services -->
<div class="section">
    <div class="container">
    	<div class="row">
    		<div class="col-md-4 col-sm-6">
    			<div class="service-wrapper">
        			<img src="img/service-icon/diamond.png" alt="Service 1">
        			<h3>Create new bitPin</h3>
        			<p>Create a new bitPin card and generate a letter to send to the user.</p>
        			{{ link_to('features', 'Create', 'class': 'btn') }}
        		</div>
    		</div>
    		<div class="col-md-4 col-sm-6">
    			<div class="service-wrapper">
        			<img src="img/service-icon/ruler.png" alt="Service 2">
        			<h3>Edit configuration</h3>
        			<p>Change the configuration for the bitPin user website.</p>
        			{{ link_to('features', 'Edit', 'class': 'btn') }}
        		</div>
    		</div>
    		<div class="col-md-4 col-sm-6">
    			<div class="service-wrapper">
        			<img src="img/service-icon/box.png" alt="Service 3">
        			<h3>Log off</h3>
        			<p><br />Exit the bitPin web admin panel.</p>
        			{{ link_to('features', 'Goodbye', 'class': 'btn') }}
        		</div>
    		</div>
    	</div>
    </div>
    <div style="min-height:300px"></div>
</div>
<!-- End Services -->