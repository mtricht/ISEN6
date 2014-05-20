from flask import Blueprint, request, abort
import filters

from Crypto.PublicKey import RSA
from Crypto import Random
from Crypto.Hash import SHA
from Crypto.Signature import PKCS1_v1_5

import base64, string

dev = Blueprint('dev', __name__, template_folder='wat')

@dev.route('/genkeys')
def generateKeys():
	random_gen = Random.new().read
	key = RSA.generate(2048, random_gen)
	private_key_plaintext = key.exportKey('PEM', 'wachtwoord', pkcs=1);
	public_key_plaintext = key.publickey().exportKey();
	privkey = RSA.importKey(private_key_plaintext, 'wachtwoord')
	pubkey = RSA.importKey(public_key_plaintext)

	message = '{"data":{"uid":10,"name":"hey"}}'
	hesj = SHA.new();
	hesj.update(message);
	signer = PKCS1_v1_5.new(privkey)
	signature = signer.sign(hesj)

	verifier = PKCS1_v1_5.new(pubkey)

	if(verifier.verify(hesj, signature)):
		print "Signature verified!"
	else:
		print "Bad signature!"

	return public_key_plaintext + '\n' + private_key_plaintext + '\n' + base64.b64encode(signature).translate(string.maketrans('+/=', '-_.'))

