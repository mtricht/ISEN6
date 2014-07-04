from flask import Blueprint, request, abort, jsonify, g
from bitcoinrpc.authproxy import JSONRPCException
import filters, simplejson, flask
from libraries.jsonh import json_error

wallet = Blueprint('wallet', __name__)

@wallet.before_request
def filter():
	error = filters.verifyrequest(request)
	if not isinstance(error, bool):
		return error

@wallet.route('/getbalance', methods=['POST'])
def getbalance():
	if not filters.required_params(request, 'account_id'):
		abort(404)

	fields = simplejson.loads(request.data)['data']

	obj = { 'balance': g.bitrpc.getbalance(fields['account_id']), \
			'type': 'bitcoin' }
	return jsonify(obj)


@wallet.route('/getaddress', methods=['POST'])
def getaddress():
	if not filters.required_params(request, 'account_id'):
		abort(404)

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
	if not filters.required_params(request, 'account_id', 'amount', 'receiving_address'):
		abort(404)

	fields = simplejson.loads(request.data)['data']
	try:
		response = g.bitrpc.sendfrom(fields['account_id'], fields['receiving_address'], fields['amount'])
	except JSONRPCException, e:
		return json_error(e.error['message'], 401)

	obj = { 'transaction_id': response, \
			'type': 'bitcoin' }
	return jsonify(obj)

@wallet.route('/test', methods=['POST'])
def test():
	return request.data
