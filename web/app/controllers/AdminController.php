<?php

use Phalcon\Http\Response;

class AdminController extends ControllerBase
{

    public function indexAction()
    {
    	$this->view->setVar("title", "Admin Panel");
    }

    public function createbitpinAction()
    {
        $this->assets->addCss('css/print.css');
        $this->view->setVar("title", "Admin Panel");
        /*$config = array(
	        "digest_alg" => "sha512",
	        "private_key_bits" => 1536,
	        "private_key_type" => OPENSSL_KEYTYPE_RSA,
		);
		$res = openssl_pkey_new($config);
		 
		openssl_pkey_export($res, $p);
		 
		 
		function pem2der($pem_data)
		{
		   $begin = "-----BEGIN PRIVATE KEY----- ";
		   $end   = "-----END";
		   $pem_data = substr($pem_data, strpos($pem_data, $begin)+strlen($begin));
		   $pem_data = substr($pem_data, 0, strpos($pem_data, $end));
		   echo $pem_data;
		   $der = base64_decode($pem_data);
		   return $der;
		}
		pem2der($p);*/
    }
}

