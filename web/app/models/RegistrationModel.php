<?php

class Registration extends \Phalcon\Mvc\Model
{
	public function getSource()
    {
        return "registrations";
    }

    protected $id;
    protected $email;
    protected $adress_street, $adress_number, $postal_code;
    protected $payment_method;
}