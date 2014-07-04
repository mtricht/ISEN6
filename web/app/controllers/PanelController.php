<?php

class PanelController extends ControllerBase
{
    public $exceptions = array('index');

    public function indexAction()
    {
    	$this->view->setVar("title", "Panel");

        // Lets start talking with the API.
        $bitPin = new bitPin();

        // What is this users card ID?
        $key = Keys::findFirst($this->user->card_id);
$key->card_id = "peter";
        // Bitcoin address.
        $this->view->setVar('bitcoinAddress', $bitPin->getAddress($key->card_id));

        // Account balance.
        $this->view->setVar('balance', $bitPin->getBalance($key->card_id));

        // Transaction history.

    }
}