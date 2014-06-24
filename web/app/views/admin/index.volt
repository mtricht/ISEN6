<!-- Services -->
<div class="section">
    <div class="container">
    	<div class="row">
    		<div class="col-md-4 col-sm-6">
    			<div class="service-wrapper">
                    {{ image('img/service-icon/diamond.png') }}
        			<h3>Accept new registrations</h3>
        			<p>Accept new registrations. Create a new bitPin card and generate a letter to send to the user.</p>
        			{{ link_to('admin/createbitpin', 'Accept', 'class': 'btn') }}
        		</div>
    		</div>
    		<div class="col-md-4 col-sm-6">
    			<div class="service-wrapper">
                    {{ image('img/service-icon/ruler.png') }}
        			<h3>Edit configuration</h3>
        			<p>Change the configuration for the bitPin user website.</p>
        			{{ link_to('features', 'Edit', 'class': 'btn') }}
        		</div>
    		</div>
    		<div class="col-md-4 col-sm-6">
    			<div class="service-wrapper">
                    {{ image('img/service-icon/ruler.png') }}
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