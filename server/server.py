"""
Required packages:
*	Flask
*	Flask-mysql
"""
from flask import g, Flask, request, abort, jsonify, Blueprint
from flaskext.mysql import MySQL
from bitcoinrpc.authproxy import AuthServiceProxy

app = Flask(__name__)
app.debug = True

# API url
app.api_url = '/api/v1'

# Application config
app.config.update(dict(
	MYSQL_DATABASE_DB = 'test',
	MYSQL_DATABASE_USER = 'root',
	MYSQL_DATABASE_PASSWORD = '',
	DEBUG = True
))

# Setup database connection
mysql = MySQL()
mysql.init_app(app)

@app.before_request
def startup():
	g.db = mysql.get_db()
	g.bitrpc = AuthServiceProxy('http://bitpin:2@steamep.com:18333');

#Import all used controllers here
from controllers.wallet import wallet as wallet_controller
from controllers.transaction import transaction as transaction_controller
from controllers.dev import dev as development_controller

# Register all controllers (blueprints) over here
app.register_blueprint(wallet_controller, url_prefix= app.api_url + '/wallet')
app.register_blueprint(transaction_controller, url_prefix= app.api_url + '/transaction')

# Test development controller for helper functions like generating keypairs
app.register_blueprint(development_controller, url_prefix= '/dev')

# Run a tiny webserver when this script is ran directly
if __name__ == '__main__':
	app.run(host='0.0.0.0')
