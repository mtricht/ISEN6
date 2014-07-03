<?php

require 'Curl.php';

class bitPin extends \Curl\Curl {

	protected $apiServer = "http://145.101.89.95:5000/api/v1/";
	protected $apiToken = "SM9fK28Nlg7PoI8cTHREjysHsYBOE42I";

	public function __construct() {
		parent::__construct();
		// JSON only.
		$this->setOpt(CURLOPT_HTTPHEADER, array(
			'Content-Type: application/json',
			'Accept: application/json'
		));
	}

	public function makeAccount($cardId) {
		$this->post($this->apiServer . 'wallet/poep', json_encode(array(
			'signature' => null,
			'data' => array(
				'api_token' => $this->apiToken,
				'account_id' => $cardId
			)
		)));
		return $this->response;
	}

	public function getBalance($cardId) {
		$this->post($this->apiServer . 'wallet/getbalance', json_encode(array(
			'signature' => null,
			'data' => array(
				'api_token' => $this->apiToken,
				'account_id' => $cardId
			)
		)));
		return $this->response;
	}

	public function makeTransaction($cardId) {

	}
	
}