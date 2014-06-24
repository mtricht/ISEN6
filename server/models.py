from flask import g
from flaskext.mysql import MySQL

def findAccount(account_id):
	db = g.db.cursor()
	db.execute('SELECT * FROM `keys` WHERE `rsa_id` = %s LIMIT 1', [account_id])
	result = db.fetchone()
	if result is None:
		return None
	return Account(result[0], result[1])

class Account:
	def __init__(self, uid, public_key):
		self.uid = uid
		self.public_key = public_key
