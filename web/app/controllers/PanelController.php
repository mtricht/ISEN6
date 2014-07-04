<?php

class PanelController extends ControllerBase
{
    public $exceptions = array();

    public function indexAction()
    {
    	$this->view->setVar("title", "Panel");

        // Lets start talking with the API.
        $bitPin = new bitPin();

        // What is this users card ID?
        $key = Keys::findFirst($this->user->card_id);

        // Bitcoin address.
        if ($key->bitcoin_address == "") {
            // Nothing in DB yet!
            $key->bitcoin_address = $bitPin->getAddress($key->card_id);
            $key->save();
        }
        $this->view->setVar('bitcoinAddress', $key->bitcoin_address);

        // Account balance.
        $this->view->setVar('balance', $bitPin->getBalance($key->card_id));

        // Transaction history.
        $this->view->setVar('transactions', $bitPin->getTransactions($key->card_id));
    }

    public function resetAction() {
        // Lets start talking with the API.
        $bitPin = new bitPin();

        $key = Keys::findFirst($this->user->card_id);
        $address = $bitPin->resetAddress($key->card_id);
        $key->bitcoin_address = $address;
        $key->save();

        // Redirect
        $this->response->redirect('panel');
    }
}