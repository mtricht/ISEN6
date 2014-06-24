from flask import Blueprint, request, abort, jsonify, g
from bitcoinrpc.authproxy import JSONRPCException
import filters, simplejson, flask
from libraries.jsonh import json_error

wallet = Blueprint('wallet', __name__, template_folder='wat')

@wallet.before_request
def filter():
	error = filters.verifyrequest(request)
	if isinstance(error, flask.Response):
		return jsonify(error)

@wallet.route('/', methods=['POST'])
def index():
	#if not filters.required_params(request, 'account'):
	#	abort(404)

	#fields = simplejson.loads(request.data)['data']
	return json_error('well played', 123,)

	#obj = { 'balance': g.bitrpc.getbalance(fields['account']), \
	#		'type': 'bitcoin' }
	#return jsonify(obj)
