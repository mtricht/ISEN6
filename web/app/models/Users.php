<?php

class Users extends \Phalcon\Mvc\Model
{

	public static function generateCredentials() {
		$possibilties = array_merge(range(0, 9), range('a', 'z'), range('A', 'Z'));
		$username = "";
		for ($length = 0; $length <= 8; $length++) {
			$username .= $possibilties[rand(0, count($possibilties)-1)];
		}
		$password = "";
		for ($length = 0; $length <= 10; $length++) {
			$password .= $possibilties[rand(0, count($possibilties)-1)];
		}
		return array(
			'username' => $username,
			'password' => $password
		);
	}

}