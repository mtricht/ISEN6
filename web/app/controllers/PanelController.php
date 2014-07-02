<?php

class PanelController extends ControllerBase
{
    public $exceptions = array('index');

    public function indexAction()
    {
    	$this->view->setVar("title", "Panel");
        // Do we have a bitcoin address?
        if (count($bitcoinAddress = BitcoinAddresses::find($this->user->bitcoin_address_id)) > 0) {
            // Bitcoin address
            $this->view->setVar('bitcoinAddress', $bitcoinAddress->bitcoin_address );
            // Account balance
            // Transaction history
            // Kunenn Overschrijven
        } else {
            // We don't have a bitcoin address, so we have yet to generate one!
            if ($this->request->isPost()) {
                BitcoinAddresses::generateBitcoinAddress($this->user->id);
                // Refresh current page now that we have a bitcoin address.
                $this->request->redirect('panel');
            }
            $this->view->pick('panel/generate');
        }
    }
}