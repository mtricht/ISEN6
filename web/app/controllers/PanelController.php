<?php

class PanelController extends ControllerBase
{
    public $exceptions = array('index');

    public function indexAction()
    {
    	$this->view->setVar("title", "Panel");

        // Bitcoin address.
        $this->view->setVar('bitcoinAddress', $this->user->bitcoin_address);

        // Lets start talking with the API.
        $bitPin = new bitPin();

        // What is this users card ID?
        $key = Keys::findFirst($this->user->card_id);

        // Account balance.
        $this->view->setVar('balance', $bitPin->getBalance($key->card_id));

        // Transaction history.

    }
}