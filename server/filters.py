from flask import g
from flaskext.mysql import MySQL
from Crypto.PublicKey import RSA
from Crypto import Random
from Crypto.Hash import SHA
from Crypto.Signature import PKCS1_v1_5
import base64, json, string, models
from libraries.jsonh import json_error

def required_params(request, *required_params):
	fields = json.loads(request.data)
	if 'data' not in fields:
		return False
	for param in required_params:
		if param not in fields['data']:
			return False
	return True


def verifyrequest(request):
	# Are we posting?
	if request.method != 'POST':
		return json_error('Only POST requests are supported.', 405)

	# Decode JSON
	jsonobj = json.loads(request.data)

	# Missing signature and not using api token.
	if 'signature' not in jsonobj and not required_params(request, 'api_token'):
		return json_error('Missing signature in request body', 424)

	# Missing account ID.
	if not required_params(request, 'account_id'):
		return json_error('Missing data.account_id in request body', 424)

	uid = jsonobj['data']['account_id']
	
	# Grab user entry from keys table
	account = models.findAccount(uid)

	# User does not exist.
	if account is None:
		return json_error('Invalid account identifier (field: data.account_id)', 424)

	# If we have an API token and it's correct, don't check the signature.
	if required_params(request, 'api_token'):
		if jsonobj['data']['api_token'] == g.api_token:
			return True
		else:
			return json_error('API token is incorrect.', 424)

	signature = jsonobj['signature']
	jsonobj.pop('signature')

	# Validate signature of request with OpenSSL
	key = RSA.importKey(account.public_key)

	requesthash = SHA.new()
	requesthash.update(json.dumps(jsonobj, separators=(',',':')))

	if not PKCS1_v1_5.new(key).verify(requesthash, base64.b64decode(str(signature).translate(string.maketrans('-_.', '+/=')))):
		return json_error('Signature does not match data in body', 401)
	else:
		return True
