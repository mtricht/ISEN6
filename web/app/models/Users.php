<?php

class Users extends \Phalcon\Mvc\Model
{

	public static function generateCredentials() {
		$possibilities = array_merge(range(0, 9), range('a', 'z'), range('A', 'Z'));
		$password = "";
		for ($length = 0; $length <= 10; $length++) {
			$password .= $possibilities[rand(0, count($possibilities)-1)];
		}
		return array(
			'username' => self::generateUsername(),
			'password' => $password
		);
	}

	protected static function generateUsername() {
		$possibilities = array_merge(range(0, 9), range('a', 'z'), range('A', 'Z'));
		$username = "";
		for ($length = 0; $length <= 8; $length++) {
			$username .= $possibilities[rand(0, count($possibilities)-1)];
		}
		$user = self::find("username = '$username'");
		// Username taken.
		if (count($user) > 0) {
			return self::generateUsername();
		} else {
			return $username;
		}
	}

}