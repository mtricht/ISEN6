from flask import Blueprint, request, jsonify
import filters, simplejson

transaction = Blueprint('transaction', __name__)

@transaction.before_request
def filter():
	error = filters.verifyrequest(request)
	if isinstance(error, dict):
		return jsonify(error)

@transaction.route('/create', methods=['POST'])
def index():
	return 'test'

