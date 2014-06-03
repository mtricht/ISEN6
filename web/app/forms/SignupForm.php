<?php

use Phalcon\Forms\Form,
    Phalcon\Forms\Element\Text,
    Phalcon\Forms\Element\Submit,
    Phalcon\Forms\Element\Select,
    Phalcon\Validation\Validator\PresenceOf,
    Phalcon\Validation\Validator\Regex,
    Phalcon\Validation\Validator\Email;

class SignupForm extends BootstrapForm
{

    public function initialize()
    {
        $this->setEntity($this);

        // Street field.
        $street = new Text('address_street');
        $street->setLabel('Street *');
        // Street is required.
        $street->addValidator(new PresenceOf(array(
            'message' => 'The street field may not be empty'
        )));
        $this->add($street);

        // House number field.
        $houseNumber = new Text('address_number');
        $houseNumber->setLabel('House Number *');
        // House number field may not be empty.
        $houseNumber->addValidator(new PresenceOf(array(
            'message' => 'The house number field may not be empty'
        )));
        // House number validation. (123-A is allowed e.g.)
        $houseNumber->addValidator(new Regex(array(
            'message' => 'Incorrect house number.',
            'pattern' => '/^[0-9\-a-zA-Z]+$/'
        )));
        $this->add($houseNumber);

        // Postal code field.
        $postalCode = new Text('postal_code');
        $postalCode->setLabel('Postal Code *');
        // Postal code field may not be empty.
        $postalCode->addValidator(new PresenceOf(array(
            'message' => 'The postal code field may not be empty'
        )));
        // Postal code validation. (2251RB)
        $postalCode->addValidator(new Regex(array(
            'message' => 'Incorrect postal code.',
            'pattern' => '/^[1-9][0-9]{3}\s?[a-zA-Z]{2}$/'
        )));
        $this->add($postalCode);

        // Email field. (Optional field)
        $email = new Text('email');
        $email->setLabel('Email');
        // Email has to be an email.
        $email->addValidator(new Email(array(
            'message' => 'The email is not valid'
        )));
        $this->add($email);

        // Payment method field.
        $paymentMethod = new Select("payment_method", array(
            '' => 'Select payment method.',
            'ideal' => 'ideal',
            'acceptgiro' => 'Acceptgiro',
            'paypal' => 'Paypal'
        ));
        $paymentMethod->setLabel('Payment Method *');
        // Payment method field may not be empty.
        $paymentMethod->addValidator(new PresenceOf(array(
            'message' => 'The payment method field may not be empty'
        )));
        $this->add($paymentMethod);

        $this->add(new Submit('Sign up'));
    }
}