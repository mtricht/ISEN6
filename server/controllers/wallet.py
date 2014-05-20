from flask import Blueprint, request, abort, jsonify, g
from bitcoinrpc.authproxy import JSONRPCException
import filters, simplejson

wallet = Blueprint('wallet', __name__, template_folder='wat')

@wallet.before_request
def filter():
	error = filters.verifyrequest(request)
	if isinstance(error, dict):
		return jsonify(error)

@wallet.route('/', methods=['POST'])
def index():
	if not filters.required_params(request, 'account'):
		abort(404)

	fields = simplejson.loads(request.data)['data'] 

	obj = { 'balance': g.bitrpc.getbalance(fields['account']), \
			'type': 'bitcoin' }
	return jsonify(obj)
