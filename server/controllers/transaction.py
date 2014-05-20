from flask import Blueprint

transaction = Blueprint('transaction', __name__)

@transaction.route('/transaction')
def index():
	return 'ye'

