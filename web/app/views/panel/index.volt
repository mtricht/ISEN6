<div class="section">
    <div class="container">
    	<div class="row">
			<h1>Panel</h1>
			<p>Your current address is: <b>{{ bitcoinAddress }}</b><br />
			Balance: {{ balance }} BTC</p>
			<p><button class="btn">Reset Bitcoin address</button></p>
			<p><b>Transaction history</b></p>
			<table class="table table-striped">
				<tr>
					<th>Date</th>
					<th>To</th>
					<th>Amount</th>
				</tr>
			</table>
		</div>
	</div>
</div>