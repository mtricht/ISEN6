<?php

require 'Curl.php';

class bitPin extends \Curl\Curl {

	protected $apiServer = "http://localhost/server/api/v1/";
	protected $apiToken = "SM9fK28Nlg7PoI8cTHREjysHsYBOE42I";

	public function __construct() {
		parent::__construct();
		// JSON only.
		$this->setOpt(CURLOPT_HTTPHEADER, array(
			'Content-Type: application/json',
			'Accept: application/json'
		));
	}

	public function getBalance($cardId) {
		$this->post($this->apiServer . 'wallet/getbalance', json_encode(array(
			'signature' => null,
			'data' => array(
				'api_token' => $this->apiToken,
				'account_id' => $cardId
			)
		)));
		return isset($this->response->balance) ? $this->response->balance : 'Error';
	}

	public function getAddress($cardId) {
		$this->post($this->apiServer . 'wallet/getaddress', json_encode(array(
			'signature' => null,
			'data' => array(
				'api_token' => $this->apiToken,
				'account_id' => $cardId
			)
		)));
		return isset($this->response->address) ? $this->response->address : 'Error';
	}

	public function getTransactions($cardId) {
		$this->post($this->apiServer . 'wallet/getreceived', json_encode(array(
			'signature' => null,
			'data' => array(
				'api_token' => $this->apiToken,
				'account_id' => $cardId
			)
		)));die(var_dump($this->response));
		return isset($this->response->wtf_is_dit) ? $this->response->wtf_is_dit : 'Error';
	}
	
}