from flask import jsonify
import base64, json, string, models

def json_error(message, code):
	return jsonify(json.loads('{"error":{"message":"' + message + '","code":' + str(code) + '}}'))