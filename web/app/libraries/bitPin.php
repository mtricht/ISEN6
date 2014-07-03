<?php

require 'Curl.php';

class bitPin extends \Curl\Curl {

	protected $apiServer = "http://localhost/server/api/v1/";

	public function makeAccount($userId) {die($this->apiServer . 'makeAccount');
		$this->post($this->apiServer . 'makeAccount', array(
			'user_id' => $userId
		));
	}

	public function getBalance($userId) {
		$this->post($this->apiServer . 'getBalance', array(
			'user_id' => $userId
		));
	}

	public function makeTransaction($userId) {

	}
	
}