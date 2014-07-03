from flask import g
from flaskext.mysql import MySQL

def findAccount(account_id):
	db = g.db.cursor()
	db.execute('SELECT `card_id`, `rsa_public_key` FROM `keys` WHERE `card_id` = %s LIMIT 1', [account_id])
	result = db.fetchone()
	if result is None:
		return None
	print("hey ho wat doe je nou die tekeningen zijn niet van jou")
	print(result[1])
	return Account(result[0], result[1])

class Account:
	def __init__(self, uid, public_key):
		self.uid = uid
		self.public_key = public_key
