<div class="section">
    <div class="container">
    	<div class="row">
			<table class="table table-striped">
				<tr>
					<th>Address</th>
					<th>Paid</th>
					<th>Accept</th>
				</tr>
				{% for registration in registrations %}
				<tr>
					<td>{{ registration.address_street }} {{ registration.address_number }}</td>
					<td><span class="octicon octicon-check"></span></td>
					<td>{{ link_to('admin/accept/' ~ registration.id, '<span class="octicon octicon-plus"></span>') }}</td>
				</tr>
				{% endfor %}
			</table>
		</div>
	</div>
</div>