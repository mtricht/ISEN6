<div class="section">
    <div class="container">
    	<div class="row">
			<h1>Panel</h1>
			<p>Your current address is: <b>{{ bitcoinAddress }}</b><br />
			Balance: {{ balance }} BTC</p>
			<p><button class="btn" id="ResetAddress">Reset Bitcoin address</button></p>
			<p><b>Transaction history</b></p>
			<table class="table table-striped">
				<tr>
					<th>Date</th>
					<th>To/From</th>
					<th>Amount</th>
				</tr>
				{% for transaction in transactions %}
					<tr>
						<td>{{ date('d/m/Y', transaction.time) }}</td>
						<td>{{ transaction.address }}</td>
						<td>{{ transaction.amount }}</td>
					</tr>
				{% endfor %}
			</table>
		</div>
	</div>
</div>