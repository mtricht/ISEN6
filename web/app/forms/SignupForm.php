<?php

use Phalcon\Forms\Form,
    Phalcon\Forms\Element\Text,
    Phalcon\Forms\Element\Submit,
    Phalcon\Validation\Validator\PresenceOf,
    Phalcon\Validation\Validator\Email;

class SignupForm extends BootstrapForm
{

    public function initialize()
    {
        $this->setEntity($this);

        // Email
        $email = new Text('email');
        $email->setLabel('Email');
        $email->addValidator(new PresenceOf(array(
            'message' => 'The e-mail is required'
        )));
        $email->addValidator(new Email(array(
            'message' => 'The email is not valid'
        )));
        $this->add($email);

        $this->add(new Submit('Sign up'));
    }
}