<?php

class PanelController extends ControllerBase
{
    public $exceptions = array('index');

    public function indexAction()
    {
    	$this->view->setVar("title", "Panel");
        // Bitcoin address
        $this->view->setVar('bitcoinAddress', $this->user->bitcoin_address);
        // Account balance
        // Transaction history
        // Kunenn Overschrijven
    }
}