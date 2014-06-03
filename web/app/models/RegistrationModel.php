<?php

class Registration extends \Phalcon\Mvc\Model
{
    protected $id;
    protected $email;
    protected $address_street, $address_number, $postal_code;
    protected $payment_method;
}