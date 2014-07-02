
<?php

use Phalcon\Forms\Form,
    Phalcon\Forms\Element\Text,
    Phalcon\Forms\Element\Password,
    Phalcon\Forms\Element\Submit,
    Phalcon\Validation\Validator\PresenceOf;

class LoginForm extends BootstrapForm
{

    public function initialize()
    {
        $this->setEntity($this);

        // Username field.
        $username = new Text('username');
        $username->setLabel('Username *');
        $this->add($username);

        // Password field.
        $password = new Password('password');
        $password->setLabel('Password *');
        $this->add($password);

        $this->add(new Submit('Login'));
    }
}