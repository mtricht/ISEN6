<?php

class Keys extends \Phalcon\Mvc\Model
{

	public static function generateKey($length)
	{
		// Create new RSA key.
    	$config = array(
	        "digest_alg" => "sha512",
	        "private_key_bits" => $length,
	        "private_key_type" => OPENSSL_KEYTYPE_RSA,
		);
		$res = openssl_pkey_new($config);
		openssl_pkey_export($res, $p);
		return self::pemToDer($p);
	}

	protected static function pemToDer($pem_data)
	{
	   $begin = "-----BEGIN PRIVATE KEY----- ";
	   $end   = "-----END";
	   $pem_data = substr($pem_data, strpos($pem_data, $begin) + strlen($begin));
	   $pem_data = substr($pem_data, 0, strpos($pem_data, $end));
	   return preg_replace('/\s+/', '', $pem_data);
	}
}