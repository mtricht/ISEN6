<?php

class bitPin extends Curl {

	public $apiServer = "http://localhost/server/api/v1/";

	public function makeAccount($userId) {
		$this->post($apiServer . 'makeAccount', array(
			'user_id' => $userId
		));
	}

	public function getBalance($userId) {
		$this->post($apiServer . 'getBalance', array(
			'user_id' => $userId
		));
	}

	public function makeTransaction($userId) {

	}
	
}