<?php

class Keys extends \Phalcon\Mvc\Model
{

	public static $keyLength = 512;

	public static function generateKey()
	{
		// Create new RSA key.
    	$config = array(
	        "digest_alg" => "sha512",
	        "private_key_bits" => self::$keyLength,
	        "private_key_type" => OPENSSL_KEYTYPE_RSA,
		);
		$res = openssl_pkey_new($config);
		$passphrase = self::generatePassphrase();
		// Grab private key.
		openssl_pkey_export($res, $p, $passphrase);
		// Grab public key.
		$publicKey = openssl_pkey_get_details($res);
		die(var_Dump(self::pemToDer($p)));
		return array(
			'privateKey' => self::pemToDer($p),
			'publicKey' => $publicKey['key'],
			'passphrase' => $passphrase
		);
	}

	protected static function pemToDer($pem_data)
	{
	   $begin = "-----BEGIN ENCRYPTED PRIVATE KEY----- ";
	   $end   = "-----END ENCRYPTED PRIVATE KEY-----";
	   $pem_data = substr($pem_data, strpos($pem_data, $begin) + strlen($begin));
	   $pem_data = substr($pem_data, 0, strpos($pem_data, $end));
	   return preg_replace('/\s+/', '', $pem_data);
	}

	protected static function generatePassphrase() {
		$possibilties = array_merge(range(0, 9), range('A', 'F'));
		$passphrase = "";
		for ($length = 0; $length < 4; $length++) {
			$passphrase .= $possibilties[rand(0, count($possibilties)-1)];
		}
		return $passphrase;
	}
}