from flask import Blueprint, request, abort, jsonify, g
from bitcoinrpc.authproxy import JSONRPCException
import filters, simplejson, flask
from libraries.jsonh import json_error

wallet = Blueprint('wallet', __name__)

@wallet.before_request
def filter():
	""" Filters every request to make sure the request is authorized and correctly implemented """
	# error is a JSONResponse when failed, True when succeeded
	error = filters.verifyrequest(request)
	if not isinstance(error, bool):
		return error

@wallet.route('/getbalance', methods=['POST'])
def getbalance():
	""" Get the current balance for a given bitcoind account

	JSON Parameters: data.account_id -- the account_id of the account you want the balance of (required).
	"""
	if not filters.required_params(request, 'account_id'):
		abort(404)

	# Load the request fields from the json query string
	fields = simplejson.loads(request.data)['data']

	obj = { 'balance': g.bitrpc.getbalance(fields['account_id']), \
			'type': 'bitcoin' }
	return jsonify(obj)


@wallet.route('/getaddress', methods=['POST'])
def getaddress():
	""" Get the currently used address for a given bitcoind account

	JSON Parameters: data.account_id -- the account_id of the account you want the address of (required).
	"""
	if not filters.required_params(request, 'account_id'):
		abort(404)

	# Load the request fields from the json query string
	fields = simplejson.loads(request.data)['data']
	try:
		response = g.bitrpc.getaccountaddress(fields['account_id'])
	except JSONRPCException, e:
		return json_error(e.error['message'], 401)

	obj = { 'account_id': fields['account_id'], \
			'address': response, \
			'type': 'bitcoin' }
	return jsonify(obj)

@wallet.route('/createtransaction', methods=['POST'])
def createtransaction():
	""" Create a new transaction of funds from a bitcoind account to a bitcoin address

	JSON Parameters: data.account_id 		-- the account_id of the account you want to transfer funds from (required).
					 data.amount     		-- the amount of BTC to transfer (required).
					 data.receiving_address -- the receiving bitcoin address (required).
	"""
	if not filters.required_params(request, 'account_id', 'amount', 'receiving_address'):
		abort(404)

	# Load the request fields from the json query string
	fields = simplejson.loads(request.data)['data']
	try:
		response = g.bitrpc.sendfrom(fields['account_id'], fields['receiving_address'], fields['amount'])
	except JSONRPCException, e:
		return json_error(e.error['message'], 401)

	obj = { 'transaction_id': response, \
			'type': 'bitcoin' }
	return jsonify(obj)

@wallet.route('/getreceived', methods=['POST'])
def getreceived():
	""" Get all transactions that have been made by and to a bitcoind account
	
	JSON Parameters: data.account_id -- the account_id of the account you want the transactions of (required).
	"""
	if not filters.required_params(request, 'account_id'):
		abort(404)

	# Load the request fields from the json query string
	fields = simplejson.loads(request.data)['data']
	try:
		response = g.bitrpc.listtransactions(fields['account_id'])
	except JSONRPCException, e:
		return json_error(e.error['message'], 401)

	obj = { 'transactions': response, \
			'type': 'bitcoin' }
	return jsonify(obj)

@wallet.route('/resetaddress', methods=['POST'])
def resetaddress():
	""" Create a new bitcoin address for a bitcoind account

	JSON Parameters: data.account_id -- the account_id of the account you want a new bitcoin address for (required).
	"""
	if not filters.required_params(request, 'account_id'):
		abort(404)

	# Load the request fields from the json query string
	fields = simplejson.loads(request.data)['data']
	try:
		response = g.bitrpc.getnewaddress(fields['account_id'])
	except JSONRPCException, e:
		return json_error(e.error['message'], 401)

	obj = { 'account_id': fields['account_id'], \
			'address': response, \
			'type': 'bitcoin' }
	return jsonify(obj)

@wallet.route('/test', methods=['POST'])
def test():
	return request.data